# UCBerkeley CS61B Project0

## Description

This is project0 code for [UCBerkeley CS61B project0: NBody Simulation](https://sp19.datastructur.es/materials/proj/proj0/proj0).

<p align = "center">
  Part of the available simulations below.
</p>

<p align="center">
  <img src="https://github.com/h4x0rMadness/UCBerkeley-cs61b/blob/master/src/week2/proj0/images/solar.gif" width="100%">
</p>
<p align = "center">
  Solar system, part of it.  
</p>
<p align="center">
  <img src="https://github.com/h4x0rMadness/UCBerkeley-cs61b/blob/master/src/week2/proj0/images/3body.gif" width="100%">
</p>
<p align = "center">
  Three body simulation.
</p>

## How to play with it
1. download this repo:
```
git clone https://github.com/h4x0rMadness/cs61b-proj0.git
```
2. direct into `proj0` folder in your terminal:
```
cd /proj0
```
3. make sure you have `java` installed and your `javac` works correctly, then compile `NBody` class first:
```
javac NBody.java
```
4. now you can choose what you wanna simulate in `data` folder, make sure give all parameters, the standard way to call `NBody` is:
```
java NBody arg1 arg2 arg3
```
where `arg1` and `arg2` are **total simulation time** and **discrete simulation interval**, both are of `double` datatype, and `arg3` is the relative path of the file you want to simulate, in this case, it should be `data/somefile.txt`, for example:
```
java NBody 157788000.0 25000.0 data/planets.txt
```

5. have fun!

`Body` and `NBody` class coded with guidance on course page, all credit to UCBerkeley cs61b.
