<#-- @ftlvariable name="" type="com.tw.registration.views.DeviceListView" -->
<html>
<head>
    <title>Devices List</title>
</head>
    <body>
        <!-- calls getDevices() and sanitizes it -->
        <h1>Devices Registered</h1>

        <#list devices as device>
            <p>
                <h2>${device.getDEVICE_TYPE()}</h2>
                <ul>
                    <li>Browser             : ${device.getBROWSER()}</li>
                    <li>Operating System    : ${device.getOPERATING_SYSTEM()}</li>
                    <li>IP Address          : ${device.getIP_ADDRESS()}</li>
                    <li>Time                : ${device.getTIME()}</li>
                </ul>
            </p>
        </#list>
    </body>
</html>