<#import "/spring.ftl" as spring />
<#assign xhtmlCompliant = true in spring>
<!DOCTYPE html>
<html>
<head>
    <title>${serviceName}</title>
</head>
<body>

<header>
    <a href="${productServiceUrl}">Products</a> | <a href="<@spring.url '/sso/logout' />">Logout</a>
</header>

<h1>${serviceName} Administration</h1>

<p>User ${principal.name} made this request.</p>

</body>
</html>
