package com.trekt.birdsofprey.gameobjects;

import com.badlogic.gdx.math.CatmullRomSpline;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by AadityaPatwari on 17/12/15.
 */
public class SplinePenguin extends Penguin {


    //Vector2[] goodDataSet = new Vector2[12];
    float speed = (float) 0.05;
    float current = 0;
    Vector2 out = new Vector2();
    CatmullRomSpline<Vector2> spline;
    //float splineControlFactor = 0;



    public SplinePenguin(int x, int y, int width, int height, boolean good, double currentadd, CatmullRomSpline<Vector2> spline) {
        super(x, y, width, height, good);
        //this.splineControlFactor = splineControlFactor;
        health = 3;
        velocity.set(0, 0);
//        goodDataSet[0] = new Vector2(-50,-50);
//        goodDataSet[1] = new Vector2(0,0);
//        goodDataSet[2] = new Vector2(50,50);
//        goodDataSet[3] = new Vector2(100,100);
//        goodDataSet[4] = new Vector2(150,50);
//        goodDataSet[5] = new Vector2(200,0);
//        goodDataSet[6] = new Vector2(250,50);
//        goodDataSet[7] = new Vector2(200,100);
//        goodDataSet[8] = new Vector2(150,150);
//        goodDataSet[9] = new Vector2(100,100);
//        goodDataSet[10] = new Vector2(50,50);
//        goodDataSet[11] = new Vector2(0,100);
        this.spline = spline;
        this.current = (float) currentadd;

       // myCatmull = new CatmullRomSpline<>(goodDataSet, false);
    }

    public void update(float delta){
        super.update(delta);

        runTime +=delta;
        if (runTime>0.5){
            canShoot = true;
            runTime = 0;
        }
        //current += (delta * speed);
       // if (current>=0) {
        //if (current >-2) {
        //try {
            //spline.derivativeAt(out, current);
            //current += (delta * speed) / out.len();
        current += delta*speed;
        System.out.println( "lalalala" + (delta * speed) / out.len() );
        //} catch (IndexOutOfBoundsException e){

        //}
        //}

        //}
        //current -= splineControlFactor*0.001;
        if(current >= 0.90) {
            //current -= 1;
            current = 0.90f;
        }

        if (current >=0) {

            spline.valueAt(out, current);
            position.set(out.x, out.y);
        }
    }

    public float getCurrent() {
        return current;
    }

    public void setCurrent(float current) {
        this.current = current;
    }

    public CatmullRomSpline<Vector2> getSpline() {
        return spline;
    }

    public void setSpline(CatmullRomSpline<Vector2> spline) {
        this.spline = spline;
    }
}
