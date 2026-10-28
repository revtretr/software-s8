# CRUD de Cursos (JavaFX + FXML + SQL Server)

Guía de Laboratorio Nro. 08 - Ingeniería de Software (UCV)

## Estructura (MVC, según el diagrama de arquitectura)

```
crud-cursos
├── lib/mssql-jdbc_auth-12.8.1.x64.dll   -> DLL de Microsoft para la Autenticación de Windows
├── sql/bdalumno.sql                      -> script de la base de datos (SQL Server)
└── src/main
    ├── java/cursos
    │   ├── Index.java, Launcher.java        -> Index.php (arranque + inyección de dependencias)
    │   ├── controller/CursoController.java  -> Controllers
    │   ├── model/ Curso, Conexion, CursoDAO -> Models
    │   └── view/  FrmIndex, FrmConsultar, FrmInsertar, FrmModificar, Vistas, Mensajes
    └── resources/cursos/view                 -> Views (archivos FXML, como hello-view.fxml)
        ├── index.fxml
        ├── frmConsultar.fxml
        ├── frmInsertar.fxml
        └── frmModificar.fxml
```

Cada `.fxml` tiene su clase en `cursos.view` con los métodos de sus botones.
Esas clases solo hablan con `CursoController`, y el controlador con `CursoDAO`.

Inyección de dependencias (por constructor), armada en `Index`:
`Conexion` -> `CursoDAO` -> `CursoController` -> `Vistas` -> `FrmConsultar` / `FrmInsertar` / `FrmModificar`

## Pasos para ejecutar

1. Abrir SQL Server Management Studio y ejecutar `sql/bdalumno.sql` completo (F5).
2. En IntelliJ: File > Open > seleccionar `pom.xml` > "Open as Project". Esperar a que Maven descargue las dependencias.
3. Ejecutar con la configuración **Launcher** (aparece arriba a la derecha, junto al botón verde de Run).
   Ya trae las opciones necesarias para que funcione la Autenticación de Windows.
4. El SQL Server debe tener TCP/IP habilitado en el puerto 1433
   (SQL Server Configuration Manager > Protocolos de SQL Server > TCP/IP > Habilitado, y reiniciar el servicio).

## Si sale "This driver is not configured for integrated authentication"

Significa que Java no encuentra el DLL. Soluciones (basta con una):

- Ejecutar con la configuración **Launcher** del paso 3 (no con el botón verde al lado de `main`).
- O copiar `lib/mssql-jdbc_auth-12.8.1.x64.dll` a la carpeta `bin` de tu JDK (donde está `java.exe`) y volver a ejecutar.

El DLL x64 es para Java de 64 bits (lo normal en Windows).

Requisitos: JDK 23 o superior y SQL Server.
