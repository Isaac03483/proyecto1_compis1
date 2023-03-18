package com.mio.cliente.boxworld

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.view.View
import com.mio.cliente.boxworld.models.World
import kotlinx.coroutines.coroutineScope
import kotlin.concurrent.thread

class DrawPanel(context: Context?, val world: World): View(context){

    private val posX = 100.0f
    private val posY = 100.0f
    private val increment = 150.0f
    private var canvas: Canvas? = null
    private val boardMatrix = world.boardMatrix
//    private val imgResIds = setOf(R.drawable.player, R.drawable.box)
//    private val bitmaps = mutableMapOf<Int, Bitmap>()

    private val paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        this.canvas = canvas

        rewrite()
    }

    //    private fun loadBitmaps(){
//        imgResIds.forEach {
//            bitmaps[it] = BitmapFactory.decodeResource(resources, it)
//        }
//    }

    private fun paintUndefined(paint: Paint, canvas: Canvas?, i: Int, j: Int){
        paint.color = Color.parseColor(world.config.undefinedColor)
        canvas?.drawRect(posX+ increment*j,posY+increment*i,posX+increment*(j+1),posY+increment*(i+1),paint)
    }

    private fun paintBox(paint: Paint, canvas: Canvas?, i: Int, j: Int){
        paint.color = Color.parseColor(world.config.boxColor)
        canvas?.drawRect(posX+ increment*j,posY+increment*i,posX+increment*(j+1),posY+increment*(i+1),paint)
    }

    private fun paintBoxOnTarget(paint: Paint, canvas: Canvas?, i: Int, j: Int){
        paint.color = Color.parseColor(world.config.boxOnTargetColor)
        canvas?.drawRect(posX+ increment*j,posY+increment*i,posX+increment*(j+1),posY+increment*(i+1),paint)
    }

    private fun paintTarget(paint: Paint, canvas: Canvas?, i: Int, j: Int){
        paint.color = Color.parseColor(world.config.targetColor)
        canvas?.drawRect(posX+ increment*j,posY+increment*i,posX+increment*(j+1),posY+increment*(i+1),paint)
    }

    private fun paintPlayer(paint: Paint, canvas: Canvas?, i: Int, j: Int){
        paint.color = Color.parseColor(world.config.playerColor)
        canvas?.drawRect(posX+ increment*j,posY+increment*i,posX+increment*(j+1),posY+increment*(i+1),paint)
//        canvas?.drawBitmap(bitmaps[R.drawable.player]!!, null, RectF(posX+ increment*j,posY+increment*i,posX+increment*(j+1),posY+increment*(i+1)), paint)
    }

    private fun paintBrick(paint: Paint, canvas: Canvas?, i: Int, j: Int){
        paint.color = Color.parseColor(world.config.brickColor)
        canvas?.drawRect(posX+ increment*j,posY+increment*i,posX+increment*(j+1),posY+increment*(i+1),paint)
    }

    private fun paintHall(paint: Paint, canvas: Canvas?, i: Int, j: Int){
        paint.color = Color.parseColor(world.config.hallColor)
        canvas?.drawRect(posX+ increment*j,posY+increment*i,posX+increment*(j+1),posY+increment*(i+1),paint)
    }



    fun rewrite(){
        canvas?.drawColor(Color.WHITE)
        paint.style = Paint.Style.FILL_AND_STROKE
//        loadBitmaps()
        for(i in 0 until world.rows){
            for(j in 0 until world.cols){

                if(boardMatrix[i][j] == null){
                    paintUndefined(paint, canvas, i, j)
                    continue
                }

                if(boardMatrix[i][j].hasBox && boardMatrix[i][j].hasTarget){
                    paintBoxOnTarget(paint, canvas, i, j)
                    continue
                }

                if(boardMatrix[i][j].hasBox){
                    paintBox(paint, canvas, i, j)
                    continue
                }

                if(boardMatrix[i][j].hasPlayer){
                    paintPlayer(paint, canvas, i, j)
                    continue
                }

                if(boardMatrix[i][j].hasTarget){
                    paintTarget(paint, canvas, i, j)
                    continue
                }


                if(boardMatrix[i][j].type == "BRICK"){
                    paintBrick(paint, canvas, i, j)
                    continue
                } else {
                    paintHall(paint, canvas, i, j)
                }


            }
        }
    }
}