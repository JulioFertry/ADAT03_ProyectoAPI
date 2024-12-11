# API Recetas

## :taco: Descripción
Esta API proporciona una forma de gestionar usuarios, ingredientes y recetas para una aplicación enfocada en la cocina.
Los usuarios pueden agregar ingredientes a su nevera virtual, y la API generará recetas basadas en los ingredientes disponibles.
Además, permite crear y listar recetas.

## :spaghetti: Estructura de la base de datos
### Tablas
**Usuarios**: Representa a los usuarios de la aplicación.
| Campo      | Tipo   | Descripción                        |
|------------|--------|------------------------------------|
| `id`       | PK     | Identificador único                |
| `nombre`   | String | Nombre del usuario                 |
| `email`    | String | Email del usuario                  |
| `password` | String | Contraseña                         |

**Ingredientes**: Representa los ingredientes que los usuarios tienen en su "nevera".
| Campo         | Tipo   | Descripción                             |
|---------------|--------|-----------------------------------------|
| `id`          | PK     | Identificador único                     |
| `usuario_id`  | FK     | Referencia al usuario propietario       |
| `nombre`      | String | Nombre del ingrediente                  |

**Recetas**: Representa las recetas disponibles en la aplicación.
| Campo         | Tipo   | Descripción                                       |
|---------------|--------|---------------------------------------------------|
| `id`          | PK     | Identificador único                               |
| `nombre`      | String | Nombre de la receta                               |
| `descripcion` | String | Descripción o pasos para preparar la receta       |
| `ingredientes`| String | Lista de ingredientes necesarios                  |

### Relaciones
- **Usuarios a Ingredientes**: Uno a muchos (un usuario puede tener varios ingredientes en su nevera) 
- **Recetas a Ingredientes**: Muchos a muchos (una receta puede tener varios ingredientes y un ingrediente se puede usar en varias recetas)

## :hamburguer: Métodos REST
### Usuarios
- `POST /usuarios`: Crear un nuevo usuario
- `GET /usuarios/{id}`: Obtener información de un usuario
- `PUT /usuarios/{id}`: Actualizar información del usuario
- `DELETE /usuarios/{id}`: Eliminar un usuario

### Ingredientes
- `POST /ingredientes`: Agregar un ingrediente a la nevera del usuario
- `GET /ingredientes`: Listar los ingredientes en la nevera del usuario autenticado
- `DELETE /ingredientes/{id}`: Eliminar un ingrediente de la nevera

### Recetas
- `POST /recetas`: Crear una nueva receta
- `GET /recetas`: Listar todas las recetas disponibles
- `GET /recetas/{id}`: Obtener detalles de una receta (incluye su lista de ingredientes)
- `GET /recetas-sugeridas`: Generar recetas basadas en los ingredientes disponibles en la nevera del usuario
