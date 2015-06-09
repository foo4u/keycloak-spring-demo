<#import "/spring.ftl" as spring />
<#assign xhtmlCompliant = true in spring>
<!DOCTYPE html>
<html>
<head>
    <title>${serviceName}</title>
</head>
<body>

<header>
    <a href="${productServiceUrl}">Products</a>
    |
    <form action="<@spring.url '/sso/logout' />" method="post">
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
        <input type="submit" name="submit" value="Logout"/>
    </form>
</header>

<h1>${serviceName}</h1>
<p>User ${principal.name} made this request.</p>

<h2>Customers</h2>
<ul>
    <#list customers as customer>
        <li>${customer}</li>
    </#list>
</ul>

</body>
</html>
