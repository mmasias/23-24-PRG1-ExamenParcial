<img src="imagenes/_67804fc8-aa97-4dd3-a254-8c9e2f663814.jpeg" align=right width=40% border=1>

# Un edificio

En la esquina de las calles Agonía con Mortificación hay un hotel con 8 plantas. En cada planta (a partir de la primera y hasta la séptima), hay 6 habitaciones. La planta baja tiene las áreas comunes, por lo que carece de ventanas: está la recepción al centro, al lado izquierdo se encuentra el comedor y al lado derecho se encuentra un salón de actos.

Cada habitación tiene persianas que cierran por completo la visibilidad de la habitación hacia el exterior. La probabilidad de encontrar la persiana abierta se ha estimado en 70% para cada hora.

Asimismo, cada habitación puede tener la luz encendida o apagada. Lo mismo, por cada hora la probabilidad de una luz encendida es del 60%. Esta es independiente de la persiana.

Desde el frontis del edificio se ven únicamente las ventanas. Y si la ventana está cerrada, se puede ver el estado del foco interior (encendido o no).

## Reto base

Simule una semana en la vida de este edificio. Muestre el mismo mediante texto [ASCII](https://es.wikipedia.org/wiki/ASCII)


### Sugerencia de presentación

```
Día 7 - 13:00h

              __/\__
   |   |   |  |####|  |   |   |
+================================+
| [ ].[ ].[*].[    ].[ ].[*].[*] |
| [o].[ ].[*].[    ].[*].[o].[o] |
| [*].[ ].[o].[    ].[*].[ ].[ ] |
| [o].[*].[ ].[    ].[o].[o].[ ] |
| [o].[ ].[o].[    ].[*].[o].[ ] |
| [*].[ ].[o].[    ].[*].[*].[ ] |
| [ ].[ ].[ ].[    ].[ ].[ ].[ ] |
|__[_______]__|[][]|__[_______]__|

[ ] -> Ventana cerrada / [o] -> Luz apagada / [*] -> Luz encendida 

```

### Estadísticas

A la gerencia del edificio le interesa hacer un seguimiento del gasto de electricidad de sus clientes. Para esto, un indicador interesante puede ser el número de horas que las habitaciones tienen la luz encendida: brinde el dato a la gerencia, indicando por cada día cuántas horas han tenido encendida la luz las habitaciones. Asimismo, indique el dato promedio de la semana (promedio también por día).

Esto es, al final de la simulación semanal, presente un esquema similar al siguiente:

```
ESTADISTICAS SEMANALES
======================
Dia 1 - 45 horas
Dia 2 - 56 horas
Dia 3 - 30 horas
Dia 4 - 30 horas
Dia 5 - 30 horas
Dia 6 - 30 horas
Dia 7 - 30 horas
======================
Promedio - 37.5 horas
----------------------

```

## Retos extendidos

### Lluvia

Algunos días llueve. Y cuando llueve, puede caer un rayo en alguno de los seis pararayos que tiene el edificio sobre su azotea. Al caer el rayo, inutiliza la electricidad de toda la columna sobre la que cae, la cual permanece todo ese día inutilizada hasta que es reparada.

```
Día 4 - 10:00h
> Un rayo ha inutilizado la columna 2 del edificio

              __/\__
   |   /   |  |####|  |   |   |
+================================+
| [ ].[X].[*].[    ].[ ].[*].[*] |
| [o].[X].[*].[    ].[*].[o].[o] |
| [*].[X].[o].[    ].[*].[ ].[ ] |
| [o].[X].[ ].[    ].[o].[o].[ ] |
| [o].[X].[o].[    ].[*].[o].[ ] |
| [*].[X].[o].[    ].[*].[*].[ ] |
| [ ].[X].[ ].[    ].[ ].[ ].[ ] |
|__[_______]__|[][]|__[_______]__|

[ ] -> Ventana cerrada  / [o] -> Luz apagada / [*] -> Luz encendida 
[#] -> En mantenimiento / [X] -> Inutilizada

```

### Mantenimiento

Algunos días, hay plantas que entran en mantenimiento.

```
Día 4 - 10:00h
> Un rayo ha inutilizado la columna 2 del edificio
> La planta 3 está en mantenimiento

              __/\__
   |   /   |  |####|  |   |   |
+================================+
| [ ].[X].[*].[    ].[ ].[*].[*] |
| [o].[X].[*].[    ].[*].[o].[o] |
| [*].[X].[o].[    ].[*].[ ].[ ] |
| [o].[X].[ ].[    ].[o].[o].[ ] |
| [#].[#].[#].[    ].[#].[#].[#] |
| [*].[X].[o].[    ].[*].[*].[ ] |
| [ ].[X].[ ].[    ].[ ].[ ].[ ] |
|__[_______]__|[][]|__[_______]__|

[ ] -> Ventana cerrada  / [o] -> Luz apagada / [*] -> Luz encendida 
[#] -> En mantenimiento / [X] -> Inutilizada
```

### Ascensor

Agregue un ascensor al edificio, el cual se mueve -de planta en planta, subiendo o bajando- cada 15 minutos. 

```
Día 4 - 10:15h
> Un rayo ha inutilizado la columna 2 del edificio
> La planta 3 está en mantenimiento
> Ascensor en la planta 5

              __/\__
   |   /   |  |####|  |   |   |
+--------------------------------+
| [ ].[X].[*].[    ].[ ].[*].[*] |
| [o].[X].[*].[    ].[*].[o].[o] |
| [*].[X].[o].[====].[*].[ ].[ ] |
| [o].[X].[ ].[    ].[o].[o].[ ] |
| [#].[#].[#].[    ].[#].[#].[#] |
| [*].[X].[o].[    ].[*].[*].[ ] |
| [ ].[X].[ ].[    ].[ ].[ ].[ ] |
|__[_______]__|[][]|__[_______]__|

[ ] -> Ventana cerrada  / [o] -> Luz apagada / [*] -> Luz encendida 
[#] -> En mantenimiento / [X] -> Inutilizada
```
