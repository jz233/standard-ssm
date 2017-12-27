<%--
  Created by IntelliJ IDEA.
  User: DouJ
  Date: 12/24/2017
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Country</title>
    <link href="${ctx}/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${ctx}/css/style.css" rel="stylesheet"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<script src="${ctx}/js/jquery-3.2.1.js"></script>
<script src="${ctx}/js/bootstrap.min.js"></script>
<div class="container">
    <div class="table-responsive">
        <table class="table table-hover table-condensed table-countries">
            <thead>
            <tr>
                <th>Name</th>
                <th>Continent</th>
                <th>Region</th>
                <th>Surface Area</th>
                <th>Population</th>
                <th>Head of State</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${countries}" var="item">
                <tr data-countrycode="${item.code}" data-toggle="modal" data-target="cityModal">
                    <td>${item.name}</td>
                    <td>${item.continent}</td>
                    <td>${item.region}</td>
                    <td>${item.surfaceArea}</td>
                    <td>${item.population}</td>
                    <td>${item.headOfState}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="modal fade" id="cityModal" tabindex="-1" role="dialog" aria-labelledby="modal_label_city"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">&times;</button>
                    <h4 class="modal-title" id="modal_label_city">模态框（Modal）标题</h4>
                </div>
                <div class="modal-body">


                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Send message</button>
                </div>
            </div>
        </div>
    </div>

    <%--分页--%>
    <jsp:include page="pagination.jsp"/>
</div>
</body>
<script type="text/javascript">
    $(function () {
        $('.table > tbody > tr').click(function () {
            var code = $(this).attr('data-countrycode');
            getCitiesByCountry(code);
        });

        /**
         * modal隐藏时调用
         */
        $('#cityModal').on('hidden.bs.modal', function() {
            alert('hidding...');
            $('.modal-body').empty();
        });
    });


    function getCitiesByCountry(code) {
        $.ajax({
            method: 'GET',
            url: '${ctx}/city/country-' + code,
        })
            .done(function (data) {
                $.each(data, function(i, value) {
                    $('.modal-body').append('<div>' + value.name + '</div>');
                });

            })
            .fail(function () {
                alert("failed --" + code);
            });

        $('#cityModal').modal();
    }
</script>
</html>
