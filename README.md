# Ecommerce Price API

Este proyecto es una API REST construida con Spring Boot para obtener los precios de productos según una fecha, un producto y una cadena de marcas específica.

## Tecnologías

- **Spring Boot**: Framework para la creación de la API.
- **Spring Data JPA**: Para gestionar la persistencia con la base de datos.
- **H2 Database**: Base de datos en memoria para pruebas.
- **JUnit 5**: Framework de pruebas unitarias.
- **Maven**: Gestor de dependencias y construcción del proyecto.

## Arquitectura

La aplicación sigue una arquitectura de capas simple:

- **Controller**: Recibe y maneja las solicitudes HTTP.
- **Service**: Contiene la lógica de negocio.
- **Repository**: Accede a la base de datos.

Además, la estructura del código sigue principios como **SOLID** y **Clean Code**, asegurando que el código sea fácil de entender, modificar y extender.

## Uso

### 1. Iniciar el Proyecto

Para iniciar el proyecto, simplemente ejecuta el siguiente comando:

mvn spring-boot:run

Esto iniciará el servidor y podrás acceder a la API.

### 2. Consultar el Precio

La API expone el siguiente endpoint para consultar el precio de un producto:
GET /api/price?productId={productId}&brandId={brandId}&applicationDate={applicationDate}

**Parámetros**:
- `productId`: ID del producto.
- `brandId`: ID de la marca (por ejemplo, `1` para ZARA).
- `applicationDate`: Fecha en formato `yyyy-MM-dd-HH.mm.ss`.

**Ejemplo de solicitud**:
GET /api/price?productId=35455&brandId=1&applicationDate=2020-06-14-10.00.00

### 3. Ejecutar las Pruebas

Puedes ejecutar los tests con el siguiente comando:
mvn test


## Patrones y Principios Usados

- **SOLID**: Se han aplicado los principios SOLID para garantizar que el código sea mantenible y escalable.
- **Clean Code**: El código está diseñado de manera que sea fácil de leer y comprender.
- **Arquitectura de Capas**: El proyecto sigue la arquitectura tradicional de capas (Controller, Service, Repository).



## Análisis de principios SOLID
	✅  Principio de Responsabilidad Única (SRP):Cada clase tiene una única responsabilidad:
		- PriceController: Gestiona las peticiones HTTP.
		- PriceService: Maneja la lógica de negocio.
		- PriceRepository: Interactúa con la base de datos.
		- DataInitializer: Inicializa la base de datos.
	
	✅ Principio de Abierto/Cerrado (OCP)
	PriceService.findApplicablePrice usa max() para determinar la prioridad, lo que facilita agregar más reglas en el futuro sin modificar la estructura.
	
	✅  Principio de Sustitución de Liskov (LSP) 
	PriceRepository extiende JpaRepository, lo que sigue la abstracción esperada sin romper la funcionalidad.
	
	✅ Principio de Segregación de Interfaces (ISP)
	PriceRepository solo define los métodos necesarios sin forzar a implementar métodos innecesarios.
	
	✅ Principio de Inversión de Dependencias (DIP) 
	La interfaz PriceRepository se inyecta en PriceService para mayor flexibilidad.



## Análisis de Clean Code
Buenas prácticas seguidas:

	✅ Código modular y organizado.
	✅ Uso de anotaciones de Spring (@Service, @Repository, 	@RestController).
	✅ Métodos con nombres claros (findApplicablePrice, getPrice).
	✅ Uso de BigDecimal para precios (evita problemas de precisión con double).
	✅ Manejo de excepciones:excepción personalizada (PriceNotFoundException)
	✅ Separación de Concerns en DataInitializer:DateUtil en una clase separada.
	✅ Tests detallados: verifican el estado y datos.

## Patrones de Diseño Utilizados
- Inyección de Dependencias (Dependency Injection): 
Utilizado en PriceController, PriceService y DataInitializer mediante  la anotación @Autowired. Permite una gestión eficiente de lasdependencias sin necesidad de instanciarlas manualmente.


- Manejo de Excepciones (Exception Handling Pattern)
PriceNotFoundException es una excepción personalizada para manejar errores cuando no se encuentra un precio. @ExceptionHandler en PriceController captura esta excepción y devuelve una respuesta adecuada.


- Singleton Pattern 
Implementado en DateUtil mediante la anotación @Bean en PriceApiApplication. Garantiza una única instancia de la utilidad de fecha en toda la aplicación.

Estos patrones mejoran la mantenibilidad, escalabilidad y reutilización del código. 


