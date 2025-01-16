{\rtf1\ansi\ansicpg1252\cocoartf2818
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\paperw11900\paperh16840\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs24 \cf0 import kotlin.properties.ReadWriteProperty\
import kotlin.reflect.KProperty\
\
\
\
open class SmartDevice(val name: String, val category: String) \{\
\
    var deviceStatus = "online"\
        protected set\
\
    open val deviceType = "unknown"\
\
    open fun turnOn() \{\
        deviceStatus = "on"\
    \}\
\
    open fun turnOff() \{\
        deviceStatus = "off"\
    \}\
    \
    /*\
     In the SmartDevice class, \
     define a printDeviceInfo() method \
     that prints a "Device name: $name, category: $category, type: $deviceType" string.\
    */\
    \
    fun printDeviceInfo()\{\
        println("Device name: $name, category: $category, type: $deviceType")\
    \}\
\}\
\
class SmartTvDevice(deviceName: String, deviceCategory: String) :\
    SmartDevice(name = deviceName, category = deviceCategory) \{\
\
    override val deviceType = "Smart TV"\
\
    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)\
\
    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)\
\
    fun increaseSpeakerVolume() \{\
        speakerVolume++\
        println("Speaker volume increased to $speakerVolume.")\
    \}\
\
    fun nextChannel() \{\
        channelNumber++\
        println("Channel number increased to $channelNumber.")\
    \}\
\
    override fun turnOn() \{\
        super.turnOn()\
        println(\
            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +\
                "set to $channelNumber."\
        )\
    \}\
\
    override fun turnOff() \{\
        super.turnOff()\
        println("$name turned off")\
    \}\
    \
    /*\
     In the SmartTvDevice class, \
     define a decreaseVolume() method that decreases the volume and \
     a previousChannel() method that navigates to the previous channel. \
     */\
     \
     fun decreaseVolume() \{\
         speakerVolume--\
         println("Speaker volume decreased to $speakerVolume.")\
	\}\
    \
    fun previousChannel() \{\
        channelNumber--\
        println("Channel number decreased to $channelNumber.")\
    \}\
\}\
\
class SmartLightDevice(deviceName: String, deviceCategory: String) :\
    SmartDevice(name = deviceName, category = deviceCategory) \{\
\
    override val deviceType = "Smart Light"\
\
    private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)\
\
    fun increaseBrightness() \{\
        brightnessLevel++\
        println("Brightness increased to $brightnessLevel.")\
    \}\
\
    override fun turnOn() \{\
        super.turnOn()\
        brightnessLevel = 2\
        println("$name turned on. The brightness level is $brightnessLevel.")\
    \}\
\
    override fun turnOff() \{\
        super.turnOff()\
        brightnessLevel = 0\
        println("Smart Light turned off")\
    \}\
    \
    /*\
    In the SmartLightDevice class, \
    define a decreaseBrightness() method that decreases the brightness.\
    */\
    \
    fun decreaseBrightness() \{\
        brightnessLevel--\
        println("Brightness decreased to $brightnessLevel.")\
    \}\
\}\
\
class SmartHome(\
    val smartTvDevice: SmartTvDevice,\
    val smartLightDevice: SmartLightDevice\
) \{\
    /*\
     In the SmartHome class, \
     ensure that all actions can only be performed \
     when each device's deviceStatus property is set to an "on" string. \
     Also, ensure that the deviceTurnOnCount property is updated correctly.\
     In the SmartHome class, define an decreaseTvVolume(), changeTvChannelToPrevious(), \
     printSmartTvInfo(), printSmartLightInfo(), and decreaseLightBrightness() method.\
     */\
\
    var deviceTurnOnCount = 0\
        private set(value)\{\
            if(value >= 0) field = value\
        \}\
\
    fun turnOnTv() \{\
        \
        if(smartTvDevice.deviceStatus == "online") \{\
            deviceTurnOnCount++\
        	smartTvDevice.turnOn()\
        \}else if (smartTvDevice.deviceStatus == "off") \{\
        	deviceTurnOnCount++\
        	smartTvDevice.turnOn()\
        \}\
    \}\
\
    fun turnOffTv() \{     \
        if(smartTvDevice.deviceStatus == "on") \{    \
        	deviceTurnOnCount--\
	        smartTvDevice.turnOff()\
        \}\
    \}\
\
    fun increaseTvVolume() \{\
        if(smartTvDevice.deviceStatus == "on") smartTvDevice.increaseSpeakerVolume()\
    \}\
    \
    fun decreaseTvVolume() \{\
        if(smartTvDevice.deviceStatus == "on") smartTvDevice.decreaseVolume()\
    \}\
\
    fun changeTvChannelToNext() \{\
        if(smartTvDevice.deviceStatus == "on") smartTvDevice.nextChannel()\
    \}\
    \
    fun changeTvChannelToPrevious() \{\
        if(smartTvDevice.deviceStatus == "on") smartTvDevice.previousChannel()\
    \}\
\
    fun turnOnLight() \{\
        if(smartLightDevice.deviceStatus == "online") \{\
            deviceTurnOnCount++\
        	smartLightDevice.turnOn()\
        \}else if(smartLightDevice.deviceStatus == "off") \{\
        	deviceTurnOnCount++\
        	smartLightDevice.turnOn()\
        \}\
    \}\
\
    fun turnOffLight() \{\
        if(smartLightDevice.deviceStatus == "on") \{\
	        deviceTurnOnCount--\
    	    smartLightDevice.turnOff()\
        \}\
    \}\
\
    fun increaseLightBrightness() \{\
        if(smartLightDevice.deviceStatus == "on") smartLightDevice.increaseBrightness()\
    \}\
    \
    fun decreaseLightBrightness() \{\
        if(smartLightDevice.deviceStatus == "on") smartLightDevice.decreaseBrightness()\
    \}\
\
\
    fun turnOffAllDevices() \{\
        if(smartTvDevice.deviceStatus == "on") turnOffTv()\
        if(smartLightDevice.deviceStatus == "on") turnOffLight()\
    \}\
    \
    fun printSmartTvInfo() \{\
        if(smartTvDevice.deviceStatus == "on") smartTvDevice.printDeviceInfo()\
    \}\
    \
    fun printLightInfo() \{\
        if(smartLightDevice.deviceStatus == "on") smartLightDevice.printDeviceInfo()\
    \}\
    \
    \
     \
\}\
\
class RangeRegulator(\
    initialValue: Int,\
    private val minValue: Int,\
    private val maxValue: Int\
) : ReadWriteProperty<Any?, Int> \{\
\
    var fieldData = initialValue\
\
    override fun getValue(thisRef: Any?, property: KProperty<*>): Int \{\
        return fieldData\
    \}\
\
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) \{\
        if (value in minValue..maxValue) \{\
            fieldData = value\
        \}\
    \}\
\}\
\
fun main() \{\
    /*\
    var smartDevice: SmartDevice = SmartTvDevice("Android TV", "Entertainment")\
    smartDevice.turnOn()\
\
    smartDevice = SmartLightDevice("Google Light", "Utility")\
    smartDevice.turnOn()\
    */\
    \
    val smartHome = SmartHome(\
        SmartTvDevice(deviceName = "Android TV", deviceCategory = "Entertainment"),\
        SmartLightDevice(deviceName = "Google light", deviceCategory = "Utility")\
    )\
    \
	smartHome.turnOffAllDevices()\
    println("Total number of devices currently turned on: $\{smartHome.deviceTurnOnCount\}")\
    smartHome.turnOnTv()\
    println("Total number of devices currently turned on: $\{smartHome.deviceTurnOnCount\}")\
    smartHome.turnOnLight()\
    println("Total number of devices currently turned on: $\{smartHome.deviceTurnOnCount\}")\
    println()\
\
    smartHome.increaseTvVolume()\
    smartHome.decreaseTvVolume()\
    smartHome.changeTvChannelToNext()\
    smartHome.changeTvChannelToPrevious()\
    smartHome.increaseLightBrightness()\
    smartHome.decreaseLightBrightness()\
    println()\
    \
    smartHome.turnOffTv()\
    println("Total number of devices currently turned on: $\{smartHome.deviceTurnOnCount\}")\
    smartHome.turnOffLight()\
    println("Total number of devices currently turned on: $\{smartHome.deviceTurnOnCount\}")\
    smartHome.turnOnTv()\
    println("Total number of devices currently turned on: $\{smartHome.deviceTurnOnCount\}")\
    smartHome.turnOnLight()\
    println("Total number of devices currently turned on: $\{smartHome.deviceTurnOnCount\}")\
    smartHome.turnOffAllDevices()\
    println("Total number of devices currently turned on: $\{smartHome.deviceTurnOnCount\}.\\n")\
    \
\
    smartHome.printSmartTvInfo()\
    smartHome.printLightInfo()\
    \
\}}