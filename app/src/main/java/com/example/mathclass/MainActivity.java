package com.example.mathclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private Button button1,button2,button3,button4,go,again;
    private TextView oper,time,score,finishscoor;
    private CountDownTimer countDownTimer;
    private int btnOk,op1,op2,res,scor = 0,essay = 0;

    private void opeHandler(){

        btnOk = (new Random().nextInt(4));
        Log.i("rondom",Double.toString(Math.random()));
        op1 = (new Random().nextInt(10));
        op2 = (new Random().nextInt(10));
        Log.i("Message ",btnOk+","+op1+","+op2);
        oper.setText(op1+"+"+op2);
        res = op1+op2;
        if(btnOk == 0){
            int x = (new Random().nextInt(10));
            button1.setText(Integer.toString(res));
            button2.setText(Integer.toString((int)(res+x+1)));
            button3.setText(Integer.toString((int)(res+x+2)));
            button4.setText(Integer.toString(res+x+3));
        }else if(btnOk == 1){
            int x = (new Random().nextInt(10));
            button2.setText(Integer.toString(res));
            button1.setText(Integer.toString((int)(res+x+1)));
            button3.setText(Integer.toString((int)(res+x+2)));
            button4.setText(Integer.toString(res+x+3));

        }else if(btnOk == 2){
            int x = (new Random().nextInt(10));
            button3.setText(Integer.toString(res));
            button2.setText(Integer.toString((int)(res+x+1)));
            button1.setText(Integer.toString((int)(res+x+2)));
            button4.setText(Integer.toString(res+x+3));

        }else if(btnOk == 3){
            int x = (new Random().nextInt(10));
            button4.setText(Integer.toString(res));
            button2.setText(Integer.toString((int)(res+x+1)));
            button3.setText(Integer.toString((int)(res+x+2)));
            button1.setText(Integer.toString(res+x+3));

        }








    }


    public void btnClick(View view){

        if(view.getTag().toString().equals("go")||view.getTag().toString().equals("again")){
            finishscoor.setVisibility(View.INVISIBLE);
            again.setVisibility(View.INVISIBLE);
            visibiliteGrid();
            go.setVisibility(View.INVISIBLE);
            time.setText("30 s");
            score.setText(scor+"/"+essay);
            countDownTimer = new CountDownTimer(30000,1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    time.setText(Integer.toString((int)millisUntilFinished/1000)+" s");
                }

                @Override
                public void onFinish() {

                    inVisibiliteGrid();
                    go.setVisibility(View.VISIBLE);
                    again.setVisibility(View.VISIBLE);
                    finishscoor.setText("Your scoor : "+scor+"/"+essay);

                }
            }.start();
            opeHandler();
        }else if(view.getTag().toString().equals("b00")){
            if(btnOk == 0){
                scor++;
                opeHandler();


            }else{opeHandler();}
            score.setText(scor+"/"+(++essay));



        }else if(view.getTag().toString().equals("b01")){
            if(btnOk == 1){
                scor++;
                opeHandler();


            }else{opeHandler();}
            score.setText(scor+"/"+(++essay));


        }else if(view.getTag().toString().equals("b10")){
            if(btnOk == 2){
                scor++;
                opeHandler();

            }else{opeHandler();}
            score.setText(scor+"/"+(++essay));

        }else if(view.getTag().toString().equals("b11")){
            if(btnOk == 3){
                scor++;
                opeHandler();


            }else{opeHandler();}
            score.setText(scor+"/"+(++essay));

        }
    }




    private void visibiliteGrid(){
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
        button4.setVisibility(View.VISIBLE);
        time.setVisibility(View.VISIBLE);
        score.setVisibility(View.VISIBLE);
        oper.setVisibility(View.VISIBLE);
    }
    private void inVisibiliteGrid(){
        button1.setVisibility(View.INVISIBLE);
        button2.setVisibility(View.INVISIBLE);
        button3.setVisibility(View.INVISIBLE);
        button4.setVisibility(View.INVISIBLE);
        time.setVisibility(View.INVISIBLE);
        score.setVisibility(View.INVISIBLE);
        oper.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.b00);
        button2 = (Button) findViewById(R.id.b01);
        button3 = (Button) findViewById(R.id.b10);
        button4 = (Button) findViewById(R.id.b11);
        again = (Button) findViewById(R.id.playagain);
        go = (Button) findViewById(R.id.go);
        oper = (TextView) findViewById(R.id.op);
        time = (TextView) findViewById(R.id.btime);
        score = (TextView) findViewById(R.id.bscore);
        finishscoor = (TextView) findViewById(R.id.finishscor);


        finishscoor.setVisibility(View.INVISIBLE);
        again.setVisibility(View.INVISIBLE);
        go.setVisibility(View.VISIBLE);
        inVisibiliteGrid();




    }
}
