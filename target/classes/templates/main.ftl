<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>

    <@l.logout />
    <br>

    <div>
        <form method="post">
            <input text="name" name="firstname" placeholder="Введите имя">
            <input text="name" name="secondname" placeholder="Введите фамилию">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit">Добавить</button>
        </form>
    </div>
    <br>

    <div>
        <form method="get" action="/main">
            <input type="text" name="firstname" placeholder="Введите имя для поиска">
            <button type="submit">Поиск</button>
        </form>
    </div>
    <br>

    <div>Список пользователей</div>
    <div>
        <#list users as user>
        <b>${user.id}</b>
        <b>${user.firstname}</b>
        <span><b>${user.secondname}</b></span>
        <strong>${user.authorName}</strong>
        <br>
            <#else> No user
        </#list>
    </div>

</@c.page>