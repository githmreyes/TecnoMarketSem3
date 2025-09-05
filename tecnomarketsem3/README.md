# SEM3 – Extensión de Funcionalidades mediante **Herencia**  
## Proyecto Académico – Plataforma e-Commerce en Java (JDK 24)

### Datos Generales
- **Curso:** CSE6041 – Programación Orientada a Objetos  
- **Docente:** Dra. María Elena Gómez Martínez  
- **Alumno:** Orlin Reyes  
- **Semana:** 3 – Extensión de Funcionalidades mediante Herencia  
- **Fecha de entrega:** Agosto 2025  

---

## 1. Descripción del Proyecto
Este proyecto implementa una **plataforma e-Commerce** como caso de estudio para aplicar **herencia** en Programación Orientada a Objetos (POO).  
La tarea consiste en **generalizar y especializar** clases ya diseñadas en semanas anteriores, extendiendo el sistema con nuevas funcionalidades:

- **Producto** → `ProductoDigital`, `ProductoFisico`  
- **Usuario** → `Cliente`, `Administrador`  

La solución está implementada en **Java 24**, gestionada con **Maven**, y lista para ser ejecutada en **Eclipse IDE**.

---

## 2. Tecnologías Utilizadas
- **Lenguaje:** Java (JDK 24)  
- **IDE:** Eclipse IDE 2025  
- **Gestión de dependencias:** Apache Maven 3.9+  
- **Paradigma:** Programación Orientada a Objetos (POO)  
- **Control de versiones:** Git y GitHub  

---

## 3. Diseño Conceptual
La **herencia** permite factorizar atributos comunes en superclases y extender comportamientos en subclases.  
Se aplican los principios de **generalización** y **especialización**:

- `Producto` (abstracto)  
  - `ProductoFisico` (peso, dimensiones, cálculo de costo de envío)  
  - `ProductoDigital` (formato, tamaño, URL de descarga, licencia)  
- `Usuario` (abstracto)  
  - `Cliente` (historial de compras, preferencias)  
  - `Administrador` (gestión de inventarios, creación de promociones)  


---

## 4. Implementación
La estructura del proyecto está organizada en paquetes:



### Descripción de las clases principales:
- **`Producto` (abstracta):** define atributos comunes (id, nombre, precio, stock).  
- **`ProductoFisico`:** extiende `Producto`, agrega peso y dimensiones; calcula costo de envío.  
- **`ProductoDigital`:** extiende `Producto`, agrega formato, tamaño y URL de descarga.  
- **`Usuario` (abstracta):** base para autenticación y validación de email.  
- **`Cliente`:** guarda historial de compras y preferencias.  
- **`Administrador`:** ajusta inventarios y crea promociones.  
- **`Carrito` y `Pedido`:** simulan el flujo de compra.  
- **Servicios (`InventarioService`, `PromocionService`):** encapsulan lógica de negocio.  
- **`SinStockException`:** maneja errores por falta de stock.  

---

## 5. Instrucciones de Ejecución

### Opción 1 – Maven CLI
```bash
git clone https://github.com/usuario/ecommerce-oop.git
cd ecommerce-oop
mvn clean install
mvn exec:java -Dexec.mainClass="com.tecnomarket.oop.App"

## 6. Capturas de Ejecución
Ejemplo de salida en consola:

```text
Precio con promo para 'Curso Java Avanzado': 39.92
Total carrito: 449.88
Pedido creado: 0e9c1f7a-4d3f-44af-b36c-90b1d39f9d1d - total: 449.88
Historial de Ana Torres: 1 pedido(s)
Costo envío monitor: 18.0
Link de descarga para Ana: https://tecnomarket.example.com/descargas/curso-java?user=ana@example.com&lic=EDU-2025

docs/images/output_pedido.png

Desafíos y Soluciones

Regex inválida (\s) en validación de email.
✔ Se corrigió usando \\s y Pattern.compile.

Advertencia de serialización en excepción.
✔ Se añadió serialVersionUID en SinStockException.

Compatibilidad con JDK 24 en Maven y Eclipse.
✔ Se fijó <maven.compiler.release>24</maven.compiler.release> en pom.xml.


Referencias Bibliográficas

Blasco, F. (2019). Programación orientada a objetos en Java. RA-MA Editorial.

Flórez Fernández, H. A. (2012). Programación orientada a objetos usando Java. Ecoe Ediciones.

Jiménez de Parga, C. (2021). UML: arquitectura de aplicaciones en Java, C++ y Python (2.ª ed.). RA-MA Editorial.

Castro, C. C., de León Amador, P. J. P., & Boró, E. S. (2006). Introducción a la programación orientada a objetos. Universidad de Alicante.

Cortés, E. L. (2004). Programación orientada a objetos. Objetos. Clases. Herencia. Polimorfismo. Temario A, Vol. II.

Oracle. (s. f.). Regular Expressions (Java Platform SE 24). Documentación oficial

Guía Didáctica CSE6041 – Object-Oriented Programming.