<#import "/spring.ftl" as spring />
<#assign xhtmlCompliant = true in spring>
<!DOCTYPE html>
<html>
<head>
    <title>${serviceName}</title>
</head>
<body>

<header>
    <a href="${customerServiceUrl}">Customers</a> | <a href="<@spring.url '/sso/logout' />">Logout</a>
</header>

<h1>${serviceName}</h1>

<p>User ${principal.name} made this request.</p>

<h2>Products</h2>
<ul>
    <#list products as product>
        <li>${product}</li>
    </#list>
</ul>

</body>
</html>
