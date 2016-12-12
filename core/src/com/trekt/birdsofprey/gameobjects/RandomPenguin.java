package com.trekt.birdsofprey.gameobjects;

import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by AadityaPatwari on 13/12/15.
 */
public class RandomPenguin extends Penguin {


    private Random random;
    private Vector2 newRandomVelocity;
    private float runtime = 0;






    public RandomPenguin(int x, int y, int width, int height, boolean good) {
        super(x, y, width, height, good);
        random = new Random();
        newRandomVelocity = new Vector2();
        velocity = getRandomVelocity();
        health = 5;

        /*

        */

    }

    @Override
    public void update(float delta) {
        //this.splineControlFactor = splineControlFactor;
        super.update(delta);

        runTime +=delta;
        if (runTime>5){
            canShoot = true;
            runTime = 0;
        }
        if (health == 0) {
            dead = true;
        }

        runtime += delta;
        if (runtime > 1) {
           velocity = getRandomVelocity();
            runtime = 0;
        }




        if (position.y <= 0){
            velocity.set(0, 10);
        }
        if (position.y + height >= gameHeight){
            velocity.set(0, -10);
        }

        if (position.x <= 0){
            velocity.set(10, 0);
        }

        if (position.x + width >= gameWidth){
            velocity.set(-10, 0);
        }






    }

    private Vector2 getRandomVelocity() {
        int randomInt = random.nextInt(4);
        switch (randomInt) {
            case 0:
                // move right
                newRandomVelocity.set(10, 0);

                break;
            case 1:
                newRandomVelocity.set(-10, 0);
                break;
            case 2:
                newRandomVelocity.set(0, 10);
                break;
            case 3:
                newRandomVelocity.set(0, -10);
                break;

        }
        return newRandomVelocity;

    }

   /*
    private void splineAI(float delta){

        current += (delta * speed);
        current -= splineControlFactor*0.001;
        if(current >= 1) {
            current -= 1;
        }
        if (current<0) {
            current = 0;
        }
        myCatmull.valueAt(out, current);
        position.set(out.x, out.y);
    }


    private void straightAI(){
        velocity.set(10, 0);
    }
*/

}
