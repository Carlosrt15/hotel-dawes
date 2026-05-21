
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Clientes</title>
 
</head>
<body>

  <a href="${pageContext.request.contextPath}/">Inicio</a>

  <form method="get" action="clientes">
    <input type="text" name="habitacion" value="${habitacionFiltro}"
           placeholder="Filtrar por habitación..."/>
    <button type="submit">Buscar</button>
    <a href="clientes">Ver todos</a>
  </form>

  <form method="post" action="clientes">
    <input type="text"  name="nombre"     placeholder="Nombre"/>
    <input type="text"  name="apellido"   placeholder="Apellido"/>
    <input type="text"  name="dni"        placeholder="DNI"/>
    <input type="email" name="email"      placeholder="Email"/>
    <input type="text"  name="habitacion" placeholder="Habitación"/>
    <button type="submit">Guardar</button>
  </form>

  <table border="1">
    <thead>
      <tr>
        <th>ID</th><th>Nombre</th><th>Apellido</th>
        <th>DNI</th><th>Email</th><th>Habitación</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${clientes}" var="cli">
        <tr>
          <td>${cli.id}</td>
          <td>${cli.nombre}</td>
          <td>${cli.apellido}</td>
          <td>${cli.dni}</td>
          <td>${cli.email}</td>
          <td>${cli.habitacion}</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>

</body>
</html>