
# Proyecto SpringBoot - Concesionario de Coches

## Autor
Pablo Andérica Torrado

## Descripción del Proyecto
Este proyecto es una aplicación SpringBoot para la gestión de un concesionario de coches. Permite a los usuarios explorar un catálogo de coches disponibles, gestionar clientes, y crear facturas de compra.

### Características Principales

- **Navegación Intuitiva**: Mediante una barra de navegación que facilita el acceso a las distintas secciones del sitio web: Home, Clientes, Coches, y Explorar Catálogo.

- **Gestión de Clientes**: Visualización de un listado de clientes, con opciones para crear, ver, editar, y eliminar clientes, además de crear facturas asociadas a cada uno.

- **Exploración de Coches**: Listado de coches disponibles con opciones para ver detalles, editar información y eliminar coches del inventario.

- **Creación de Facturas**: Funcionalidad para generar facturas por la compra de coches, asociadas a los clientes.

### Implementación

- **Frontend Visual**: La interfaz de usuario ofrece una experiencia visualmente atractiva y amigable para el usuario, incluyendo un sistema de paginación y tarjetas interactivas para cada cliente y coche.

- **Backend Robusto**: El backend está construido con SpringBoot, proporcionando una base sólida para la lógica de negocio y la gestión de datos.

### Tecnologías Utilizadas

- SpringBoot para el backend.
- HTML, CSS, Tailwind y JavaScript para el frontend.
- Base de datos relacional para el almacenamiento de datos.

## Instalación y Configuración

1. **Pre-requisitos**:
   - Java JDK 17 mínimo.
   - XAMP o cualquier otro servidor local para la base de datos.

2. **Configuración de la Base de Datos**:
   - Crear una base de datos llamada `db_coches`.

3. **Despliegue**:
   - Navegar al directorio del proyecto y ejecutar `./mvnw.cmd package` para generar el archivo `.JAR`.
   - Ejecutar el archivo `.JAR` desde la línea de comandos para lanzar la aplicación.
   - Acceder a la aplicación a través de `localhost:8080` en el navegador.

## Créditos
Desarrollado por Pablo Andérica Torrado como parte de un proyecto educativo para 2ºDAM.
