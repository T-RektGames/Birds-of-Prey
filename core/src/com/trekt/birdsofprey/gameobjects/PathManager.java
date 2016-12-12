package com.trekt.birdsofprey.gameobjects;

import com.badlogic.gdx.math.CatmullRomSpline;
import com.badlogic.gdx.math.Vector2;
import com.trekt.birdsofprey.helpers.AssetLoader;

/**
 * Created by AadityaPatwari on 17/12/15.
 */
public class PathManager {

    private CatmullRomSpline<Vector2> goodSpline0, goodSpline1, goodSpline2, goodSpline3;
    private CatmullRomSpline<Vector2> badSpline0, badSpline1, badSpline2, badSpline3;
    private Vector2[] goodDataSet0, goodDataSet1, goodDataSet2, goodDataSet3;
    private Vector2[] badDataSet0, badDataSet1, badDataSet2, badDataSet3;
    private int gameWidth = AssetLoader.gameWidth;
    private int gameHeight = AssetLoader.gameHeight;


    public PathManager() {
        goodDataSet0 = new Vector2[9];
//        goodDataSet0[0] = new Vector2(-400, 25);
//        goodDataSet0[1] = new Vector2(-300, 25);
//        goodDataSet0[2] = new Vector2(-200, 25);
        goodDataSet0[0] = new Vector2(-100, 25);

        //goodDataSet0[1] = new Vector2(-50,25);
        goodDataSet0[1] = new Vector2(0, 25);
        goodDataSet0[2] = new Vector2(100, 30);
        goodDataSet0[3] = new Vector2(200, 35);
        //goodDataSet[] = new Vector2(230,67);
        goodDataSet0[4] = new Vector2(230, 72);
        goodDataSet0[5] = new Vector2(200, 109);
        goodDataSet0[6] = new Vector2(100, 114);
        goodDataSet0[7] = new Vector2(0, 119);
        // goodDataSet0[8] = new Vector2(-50,119);
        goodDataSet0[8] = new Vector2(-100, 119);
//        goodDataSet0[12] = new Vector2(-200, 119);
//        goodDataSet0[13] = new Vector2(-300, 119);
//        goodDataSet0[14] = new Vector2(-400, 119);
        //goodDataSet0[8] = new Vector2(150,150);
        // goodDataSet0[9] = new Vector2(100,100);
        // goodDataSet0[10] = new Vector2(50,50);
        // goodDataSet0[11] = new Vector2(0,100);
        goodSpline0 = new CatmullRomSpline<>(goodDataSet0, true);

        badDataSet0 = new Vector2[9];
        for (int i = 0; i < badDataSet0.length; i++) {
            badDataSet0[i] = new Vector2(gameWidth - goodDataSet0[i].x, goodDataSet0[i].y);
        }
        badSpline0 = new CatmullRomSpline<>(badDataSet0, true);

        goodDataSet1 = new Vector2[11];
//        goodDataSet1[0] = new Vector2(-gameWidth * 7 / 8, gameHeight / 2);
//        goodDataSet1[1] = new Vector2(-gameWidth * 6 / 8, gameHeight / 2);
//        goodDataSet1[2] = new Vector2(-gameWidth * 5 / 8, gameHeight / 2);
//        goodDataSet1[3] = new Vector2(-gameWidth * 4 / 8, gameHeight / 2);
//        goodDataSet1[4] = new Vector2(-gameWidth * 3 / 8, gameHeight / 2);
//        goodDataSet1[5] = new Vector2(-gameWidth * 2 / 8, gameHeight / 2);
        goodDataSet1[0] = new Vector2(-gameWidth / 8, gameHeight / 2);
        goodDataSet1[1] = new Vector2(0, gameHeight / 2);
        goodDataSet1[2] = new Vector2(gameWidth / 8, gameHeight / 4);
        //goodDataSet4[3] = new Vector2(230,67);
        goodDataSet1[3] = new Vector2(gameWidth / 4, gameHeight / 2);
        goodDataSet1[4] = new Vector2(gameWidth * 3 / 8, gameHeight * 3 / 4);
        goodDataSet1[5] = new Vector2(gameWidth / 2, gameHeight / 2);
        goodDataSet1[6] = new Vector2(gameWidth * 5 / 8, gameHeight * 1 / 4);
        goodDataSet1[7] = new Vector2(gameWidth * 6 / 8, gameHeight / 2);
        goodDataSet1[8] = new Vector2(gameWidth * 7 / 8, gameHeight * 3 / 4);
        goodDataSet1[9] = new Vector2(gameWidth, gameHeight / 2);
        goodDataSet1[10] = new Vector2(gameWidth * 9 / 8, gameHeight / 2);
//        goodDataSet1[17] = new Vector2(gameWidth * 10 / 8, gameHeight / 2);
//        goodDataSet1[18] = new Vector2(gameWidth * 11 / 8, gameHeight / 2);
//        goodDataSet1[19] = new Vector2(gameWidth * 12 / 8, gameHeight / 2);
//        goodDataSet1[20] = new Vector2(gameWidth * 13 / 8, gameHeight / 2);
//        goodDataSet1[21] = new Vector2(gameWidth * 14 / 8, gameHeight / 2);
//        goodDataSet1[22] = new Vector2(gameWidth * 15 / 8, gameHeight / 2);

        goodSpline1 = new CatmullRomSpline<>(goodDataSet1, true);

        badDataSet1 = new Vector2[11];
        for (int i = 0; i < badDataSet1.length; i++) {
            badDataSet1[i] = new Vector2(goodDataSet1[i].x, gameHeight - goodDataSet1[i].y);
        }
        badSpline1 = new CatmullRomSpline<>(badDataSet1,true);

        //goodDataSet2 = new Vector2[10];



        goodDataSet2 = new Vector2[11];
        goodDataSet2[0] = new Vector2(gameWidth/2,-gameHeight*2/8);
        goodDataSet2[1] = new Vector2(gameWidth/2,0);
        goodDataSet2[2] = new Vector2(gameWidth/2,gameHeight*2/8);
        goodDataSet2[3] = new Vector2(gameWidth*2/8,gameHeight/2);
        goodDataSet2[4] = new Vector2(gameWidth/2,gameHeight*6/8);
        goodDataSet2[5] = new Vector2(gameWidth*6/8, gameHeight/2);
        goodDataSet2[6] = new Vector2(gameWidth/2, gameHeight*2/8);
        goodDataSet2[7] = new Vector2(gameWidth/2, gameHeight/2);
        goodDataSet2[8] = new Vector2(gameWidth/2, gameHeight*6/8);
        goodDataSet2[9] = new Vector2(gameWidth/2, gameHeight);
        goodDataSet2[10] = new Vector2(gameWidth/2, gameHeight*10/8);
        goodSpline2 = new CatmullRomSpline<>(goodDataSet2, true);

        badDataSet2 = new Vector2[11];
        for (int i = 0; i < badDataSet2.length; i++) {
            badDataSet2[i] = new Vector2(gameWidth - goodDataSet2[i].x, gameHeight - goodDataSet2[i].y);
        }
        badSpline2 = new CatmullRomSpline<>(badDataSet2,true);
//        goodDataSet1[4] = new Vector2(150,0);
//        goodDataSet1[5] = new Vector2(200,50);
//        goodDataSet1[6] = new Vector2(250,100);
//        goodDataSet1[7] = new Vector2(200,150);
//        goodDataSet1[8] = new Vector2(150,150);
//        goodDataSet1[9] = new Vector2(100,100);
//        goodDataSet1[10] = new Vector2(50,50);
//        goodDataSet1[11] = new Vector2(0,0);

        //spline1.


    }

    public CatmullRomSpline<Vector2> getGoodSpline0() {
        return goodSpline0;
    }

    public void setGoodSpline0(CatmullRomSpline<Vector2> goodSpline0) {
        this.goodSpline0 = goodSpline0;
    }

    public CatmullRomSpline<Vector2> getGoodSpline1() {
        return goodSpline1;
    }

    public CatmullRomSpline<Vector2> getGoodSpline2() {
        return goodSpline2;
    }

    public CatmullRomSpline<Vector2> getBadSpline0() {
        return badSpline0;
    }

    public CatmullRomSpline<Vector2> getBadSpline1() {
        return badSpline1;
    }

    public CatmullRomSpline<Vector2> getBadSpline2() {
        return badSpline2;
    }

    public CatmullRomSpline<Vector2> getBadSpline3() {
        return badSpline3;
    }
}
