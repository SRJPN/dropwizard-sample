<#-- @ftlvariable name="" type="com.tw.registration.views.DeviceView" -->
<html>
    <head>
        <title>Device</title>
    </head>
    <body>
        <!-- calls getDevice() and sanitizes it -->
        <h1>${device.getDEVICE_TYPE()}</h1>
        <ul>
            <li>Browser             : ${device.getBROWSER()}</li>
            <li>Operating System    : ${device.getOPERATING_SYSTEM()}</li>
            <li>IP Address          : ${device.getIP_ADDRESS()}</li>
            <li>Time                : ${device.getTIME()}</li>
        </ul>
    </body>
</html>