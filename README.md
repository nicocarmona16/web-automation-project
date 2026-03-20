# web-automation-project

Proyecto de automatización de pruebas web para la página [SauceDemo](https://www.saucedemo.com/).

## Tecnologías Utilizadas
* **Lenguaje:** Java 8+
* **Herramienta principal:** Selenium WebDriver
* **Framework de Pruebas:** TestNG
* **Gestor de Dependencias:** Maven
* **Gestor de Drivers:** WebDriverManager

## Arquitectura y Patrones Aplicados
* Page Object Model (POM)
* Page Factory
* Data-Driven
* Configuración de entornos y URLs a través del archivo `testng.xml`

## Escenarios Automatizados
1. **Purchase Product:** Flujo de compra completo, agregando un producto aleatorio al carrito y finalizando el checkout
2. **Remove Elements:** Verificación de la eliminación de varios productos del carrito de compras
3. **Logout:** Validación del cierre de sesión y redirección a la pantalla de inicio

## Cómo Ejecutar las Pruebas

Para ejecutar la suite completa:
1. Clonar el repositorio
2. Abrir el proyecto en el IDE
3. Tener las dependencias de maven descargadas
4. Hacer clic derecho en el archivo `testng.xml` (ubicado en src/test/resources) y seleccionar **Run '...\src\test\resources\testng.xml'**.