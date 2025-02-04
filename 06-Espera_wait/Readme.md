## Respostes a les preguntes

### 1. Per què s'atura l'execució al cap d'un temps?
L'execució s'atura perquè arriba un moment en què ningú pot fer res més. Si l'esdeveniment està ple i ningú cancel·la, tot queda bloquejat i els fils es queden esperant.

### 2. Què passaria si canviem la probabilitat de reserva i cancel·lació?
Si canviem la probabilitat a 70% de reservar i 30% de cancel·lar, les places s'omplen ràpid i gairebé ningú pot cancel·lar, fent que els assistents es quedin atrapats sense poder reservar:

```java
if (random.nextInt(100) < 70) {
    esdeveniment.ferReserva(this);
} else {
    esdeveniment.cancelReserva(this);
}
```

Sortida:
```
Assistent-0 ha fet una reserva. Places disponibles: 4
Assistent-1 ha fet una reserva. Places disponibles: 3
...
Assistent-5 no ha pogut fer la reserva. No hi ha places disponibles.
```

Si fem el contrari (30% de reservar i 70% de cancel·lar), el sistema es torna més dinàmic i els assistents alteren més entre reservar i cancel·lar:

```java
if (random.nextInt(100) < 30) {
    esdeveniment.ferReserva(this);
} else {
    esdeveniment.cancelReserva(this);
}
```

Sortida:
```
Assistent-0 ha fet una reserva. Places disponibles: 4
Assistent-1 ha cancel·lat una reserva. Places disponibles: 5
Assistent-2 ha fet una reserva. Places disponibles: 4
...
```

### 3. Per què fa falta una llista i no només una variable de reserves?
No es pot fer només amb una variable de reserves perquè no sabríem qui ha reservat. Qualsevol podria intentar cancel·lar sense haver reservat abans. Amb una llista, controlem qui té reserva i qui pot cancel·lar, fent que tot funcioni millor.