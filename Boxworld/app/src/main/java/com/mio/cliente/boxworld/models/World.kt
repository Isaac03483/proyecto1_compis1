package com.mio.cliente.boxworld.models

import android.os.Build
import androidx.annotation.RequiresApi
import com.mio.cliente.boxworld.builders.MatrixBuilder
import com.mio.cliente.boxworld.builders.PointBuilder
import com.mio.cliente.boxworld.builders.WorldBuilder
import com.mio.cliente.boxworld.compiler.parser.MovesParserSym
import com.mio.cliente.boxworld.compiler.parser.XMLParserSym
import java.io.Serializable
import java.lang.Exception
import java.util.Objects
import java.util.Optional

data class World(val worldBuilder: WorldBuilder): Cloneable, Serializable {

    val name: String = worldBuilder.name
    val rows: Int = worldBuilder.rows
    val cols: Int= worldBuilder.cols
    val config =worldBuilder.worldConfig
    val board = worldBuilder.boards
    val boxes= worldBuilder.boxes
    val targets = worldBuilder.targets
    var player = worldBuilder.player

    val boardMatrix = MatrixBuilder().makeMatrix(this)
    override fun toString(): String {
        return "World(name='$name', rows=$rows, cols=$cols, config=$config, board=$board, boxes=$boxes, targets=$targets, player=$player)"
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    fun movePlayer(move: Move){
        when(move.direction){
            MovesParserSym.LEFT -> moveLeft(move.number.toInt(), move.push)
            MovesParserSym.RIGHT -> moveRight(move.number.toInt(), move.push)
            MovesParserSym.UP -> moveUp(move.number.toInt(), move.push)
            MovesParserSym.DOWN -> moveDown(move.number.toInt(), move.push)

        }
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private fun moveLeft(number: Int, push: Boolean){
        if(push){

            for(i in 0 until number){
                val boxPoint = Point(PointBuilder().withPosX(player.posX-1).withPosY(player.posY))
                val optionalBox = boxPresentAt(boxPoint)

                if(optionalBox.isPresent){
                    val boardPoint = Point(PointBuilder().withPosX(boxPoint.posX-1).withPosY(boxPoint.posY))
                    val optionalBoard = boardWithPointAt(boardPoint)

                    if(optionalBoard.isPresent && !boardMatrix[boardPoint.posY][boardPoint.posX].hasBox){
                        boardMatrix[boardPoint.posY][boardPoint.posX].hasBox = true
                        boardMatrix[boxPoint.posY][boxPoint.posX].hasBox = false
                        boardMatrix[boxPoint.posY][boxPoint.posX].hasPlayer = true
                        boardMatrix[player.posY][player.posX].hasPlayer = false
                        player = boxPoint
                        optionalBox.get().posX = boardPoint.posX
                        optionalBox.get().posY = boardPoint.posY

                    } else {
                        println("No se puede mover a la pos ${boardPoint.posY}${boardPoint.posX} ya que no es HALL")

                    }


                } else {
                    println("No se ha encontrado ninguna caja en la posición ${boxPoint.posY}${boxPoint.posX}")
                }


            }

        } else {
            for(i in 0 until number){
                println("POSICION ACTUAL DEL JUGADOR {${player.posY}}{${player.posX}}")
                val newPoint = Point(PointBuilder().withPosX(player.posX-1).withPosY(player.posY))
                println("POSICION NUEVA DEL JUGADOR {${newPoint.posY}}{${newPoint.posX}}")
                val optionalPoint = boardWithPointAt(newPoint)

                println("Optional = $optionalPoint")
                if(optionalPoint.isPresent){
                    val boxesOptional = boxes.stream().filter { Objects.equals(it, newPoint) }.findFirst()
                    if(boxesOptional.isEmpty){
                        println("Moviendo a jugador a nueva posición")
                        boardMatrix[newPoint.posY][newPoint.posX].hasPlayer = true
                        boardMatrix[player.posY][player.posX].hasPlayer =false
                        player = newPoint

                    } else {
                        println("No se pudo mover ya que la pos [${newPoint.posY}][${newPoint.posX}] es una caja.")
                        break
                    }

                } else {
                    println("No se pudo mover ya que la pos [${newPoint.posY}][${newPoint.posX}] no es un HALL")
                    break

                }

            }
        }
    }

    private fun boxPresentAt(boxPoint: Point): Optional<Point>{
        return boxes.stream().filter { Objects.equals(it, boxPoint) }.findFirst()
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private fun moveRight(number: Int, push: Boolean){

        if(push){
            for(i in 0 until number){
                val boxPoint = Point(PointBuilder().withPosX(player.posX+1).withPosY(player.posY))
                val optionalBox = boxPresentAt(boxPoint)

                if(optionalBox.isPresent){
                    val boardPoint = Point(PointBuilder().withPosX(boxPoint.posX+1).withPosY(boxPoint.posY))
                    val optionalBoard = boardWithPointAt(boardPoint)

                    if(optionalBoard.isPresent && !boardMatrix[boardPoint.posY][boardPoint.posX].hasBox){
                        boardMatrix[boardPoint.posY][boardPoint.posX].hasBox = true
                        boardMatrix[boxPoint.posY][boxPoint.posX].hasBox = false
                        boardMatrix[boxPoint.posY][boxPoint.posX].hasPlayer = true
                        boardMatrix[player.posY][player.posX].hasPlayer = false
                        player = boxPoint
                        optionalBox.get().posX = boardPoint.posX
                        optionalBox.get().posY = boardPoint.posY

                    } else {
                        println("No se puede mover a la pos ${boardPoint.posY}${boardPoint.posX} ya que no es HALL")

                    }


                } else {
                    println("No se ha encontrado ninguna caja en la posición ${boxPoint.posY}${boxPoint.posX}")
                }


            }
        } else {
            for(i in 0 until number){
                println("POSICION ACTUAL DEL JUGADOR {y=${player.posY}}{x=${player.posX}}")

                val newPoint = Point(PointBuilder().withPosX(player.posX+1).withPosY(player.posY))
                println("POSICION NUEVA DEL JUGADOR {y=${newPoint.posY}}{x=${newPoint.posX}}")

                val optionalPoint = boardWithPointAt(newPoint)

                if(optionalPoint.isPresent){
                    val boxesOptional = boxes.stream().filter { Objects.equals(it, newPoint) }.findFirst()
                    if(boxesOptional.isEmpty){
                        println("Moviendo a jugador a nueva posición")

                        boardMatrix[newPoint.posY][newPoint.posX].hasPlayer = true
                        boardMatrix[player.posY][player.posX].hasPlayer =false
                        player = newPoint

                    } else {
                        println("No se pudo mover ya que la pos [${newPoint.posY}][${newPoint.posX}] es una caja.")
                        break
                    }

                } else {
                    println("No se pudo mover ya que la pos [${newPoint.posY}][${newPoint.posX}] no es un HALL")
                    break

                }


            }
        }
    }

    private fun boardWithPointAt(newPoint: Point): Optional<Point?>{
        return board.stream().map{
            if(it.type == XMLParserSym.terminalNames[XMLParserSym.HALL]){
                return@map it.point
            }

            return@map null
        }.filter{Objects.equals(it, newPoint)}.findFirst()
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private fun moveUp(number: Int, push: Boolean){
        if(push){
            for(i in 0 until number){
                val boxPoint = Point(PointBuilder().withPosX(player.posX).withPosY(player.posY-1))
                val optionalBox = boxPresentAt(boxPoint)

                if(optionalBox.isPresent){
                    val boardPoint = Point(PointBuilder().withPosX(boxPoint.posX).withPosY(boxPoint.posY-1))
                    val optionalBoard = boardWithPointAt(boardPoint)

                    if(optionalBoard.isPresent && !boardMatrix[boardPoint.posY][boardPoint.posX].hasBox){
                        boardMatrix[boardPoint.posY][boardPoint.posX].hasBox = true
                        boardMatrix[boxPoint.posY][boxPoint.posX].hasBox = false
                        boardMatrix[boxPoint.posY][boxPoint.posX].hasPlayer = true
                        boardMatrix[player.posY][player.posX].hasPlayer = false
                        player = boxPoint
                        optionalBox.get().posX = boardPoint.posX
                        optionalBox.get().posY = boardPoint.posY

                    } else {
                        println("No se puede mover a la pos ${boardPoint.posY}${boardPoint.posX} ya que no es HALL")

                    }


                } else {
                    println("No se ha encontrado ninguna caja en la posición ${boxPoint.posY}${boxPoint.posX}")
                }

            }
        } else {
            for(i in 0 until number){
                println("POSICION ACTUAL DEL JUGADOR {${player.posY}}{${player.posX}}")

                val newPoint = Point(PointBuilder().withPosX(player.posX).withPosY(player.posY-1))
                println("POSICION NUEVA DEL JUGADOR {${newPoint.posY}}{${newPoint.posX}}")

                val optionalPoint = boardWithPointAt(newPoint)

                if(optionalPoint.isPresent){
                    val boxesOptional = boxes.stream().filter { Objects.equals(it, newPoint) }.findFirst()
                    if(boxesOptional.isEmpty){
                        println("Moviendo a jugador a nueva posición")

                        boardMatrix[newPoint.posY][newPoint.posX].hasPlayer = true
                        boardMatrix[player.posY][player.posX].hasPlayer =false
                        player = newPoint

                    } else {
                        println("No se pudo mover ya que la pos [${newPoint.posY}][${newPoint.posX}] es una caja.")
                        break
                    }

                } else {
                    println("No se pudo mover ya que la pos [${newPoint.posY}][${newPoint.posX}] no es un HALL")
                    break

                }

            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private fun moveDown(number: Int, push: Boolean){
        if(push){
            for(i in 0 until number){
                val boxPoint = Point(PointBuilder().withPosX(player.posX).withPosY(player.posY+1))
                val optionalBox = boxPresentAt(boxPoint)

                if(optionalBox.isPresent){
                    val boardPoint = Point(PointBuilder().withPosX(boxPoint.posX).withPosY(boxPoint.posY+1))
                    val optionalBoard = boardWithPointAt(boardPoint)

                    if(optionalBoard.isPresent && !boardMatrix[boardPoint.posY][boardPoint.posX].hasBox){
                        boardMatrix[boardPoint.posY][boardPoint.posX].hasBox = true
                        boardMatrix[boxPoint.posY][boxPoint.posX].hasBox = false
                        boardMatrix[boxPoint.posY][boxPoint.posX].hasPlayer = true
                        boardMatrix[player.posY][player.posX].hasPlayer = false
                        player = boxPoint
                        optionalBox.get().posX = boardPoint.posX
                        optionalBox.get().posY = boardPoint.posY

                    } else {
                        println("No se puede mover a la pos ${boardPoint.posY}${boardPoint.posX} ya que no es HALL")

                    }


                } else {
                    println("No se ha encontrado ninguna caja en la posición ${boxPoint.posY}${boxPoint.posX}")
                }

            }
        } else {
            for(i in 0 until number){
                println("POSICION ACTUAL DEL JUGADOR {${player.posY}}{${player.posX}}")

                val newPoint = Point(PointBuilder().withPosX(player.posX).withPosY(player.posY+1))
                println("POSICION NUEVA DEL JUGADOR {${newPoint.posY}}{${newPoint.posX}}")

                val optionalPoint = boardWithPointAt(newPoint)
                println("Optional = $optionalPoint")

                if(optionalPoint.isPresent){
                    val boxesOptional = boxes.stream().filter { Objects.equals(it, newPoint) }.findFirst()
                    if(boxesOptional.isEmpty){
                        println("Moviendo a jugador a nueva posición")

                        boardMatrix[newPoint.posY][newPoint.posX].hasPlayer = true
                        boardMatrix[player.posY][player.posX].hasPlayer =false
                        player = newPoint

                    } else {
                        println("No se pudo mover ya que la pos  es una caja.")
                        break
                    }

                } else {
                    println("No se pudo mover ya que la pos [${newPoint.posY}][${newPoint.posX}] no es un HALL")
                    break

                }

            }
        }
    }


}