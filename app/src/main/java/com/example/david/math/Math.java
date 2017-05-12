package com.example.david.math;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static android.R.attr.data;
import static android.R.attr.text;

public class Math extends AppCompatActivity {
    ImageView f1, f2, f3, f21, f22, f31, f32, f33, result;
    String fruits[]={"apple", "pear", "strawberry"};
    int value[]=new int[3];
    int playCounter=0;
    EditText textNr;
    TextView answer1;
    TextView answer2;
    TextView answer3;
    Button button;
    private int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);
        f1=(ImageView)findViewById(R.id.f1);
        f2=(ImageView)findViewById(R.id.f2);
        f3=(ImageView)findViewById(R.id.f3);
        f21=(ImageView)findViewById(R.id.f21);
        f22=(ImageView)findViewById(R.id.f22);
        f31=(ImageView)findViewById(R.id.f31);
        f32=(ImageView)findViewById(R.id.f32);
        f33=(ImageView)findViewById(R.id.f33);
        result=(ImageView)findViewById(R.id.result);

        answer1=(TextView)findViewById(R.id.answer1);
        answer2=(TextView)findViewById(R.id.answer2);
        answer3=(TextView)findViewById(R.id.answer3);
        button=(Button)findViewById(R.id.button);



        startGame();


    }
    private void putFruits(){
    Random randomOne=new Random();
        for(int i=0;i<fruits.length;i++){
            int index=randomOne.nextInt(fruits.length);
            String temp=fruits[i];
            fruits[i]=fruits[index];
            fruits[index]=temp;
        }
    }
    private void putValues(){
        Random randomOne=new Random();
        for(int i=0;i<3;i++){
            value[i]=randomOne.nextInt(6)+1;
        }

    }
    private void startGame(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setText("NEXT");
                textNr=(EditText)findViewById(R.id.rightAnswer);
                String num=textNr.getText().toString();
                if(Integer.toString(value[2]).equals(num)){
                    score++;
                }
                textNr.setText("");
                putFruits();
                putValues();
                play();
            }
        });


    }

    private void play(){
        if(fruits[0].equals("apple")){
            f1.setImageResource(R.drawable.apple);
            f2.setImageResource(R.drawable.apple);
            f3.setImageResource(R.drawable.apple);
            f31.setImageResource(R.drawable.apple);
        }else if(fruits[0].equals("pear")){
            f1.setImageResource(R.drawable.pear);
            f2.setImageResource(R.drawable.pear);
            f3.setImageResource(R.drawable.pear);
            f31.setImageResource(R.drawable.pear);
        }else if(fruits[0].equals("strawberry")){
            f1.setImageResource(R.drawable.strawberry);
            f2.setImageResource(R.drawable.strawberry);
            f3.setImageResource(R.drawable.strawberry);
            f31.setImageResource(R.drawable.strawberry);
        }

        if(fruits[1].equals("apple")){
            f21.setImageResource(R.drawable.apple);
            f22.setImageResource(R.drawable.apple);
            f32.setImageResource(R.drawable.apple);
        }else if(fruits[1].equals("pear")){
            f21.setImageResource(R.drawable.pear);
            f22.setImageResource(R.drawable.pear);
            f32.setImageResource(R.drawable.pear);
        }else if(fruits[1].equals("strawberry")){
            f21.setImageResource(R.drawable.strawberry);
            f22.setImageResource(R.drawable.strawberry);
            f32.setImageResource(R.drawable.strawberry);
        }

        if(fruits[2].equals("apple")){
            f33.setImageResource(R.drawable.apple);
            result.setImageResource(R.drawable.apple);

        }else if(fruits[2].equals("pear")){
            f33.setImageResource(R.drawable.pear);
            result.setImageResource(R.drawable.pear);
        }else if(fruits[2].equals("strawberry")){
            f33.setImageResource(R.drawable.strawberry);
            result.setImageResource(R.drawable.strawberry);
        }

        calculateValues();

    }
    private void calculateValues(){

        int first=value[0];
        int second=value[1];
        int third=value[2];
        int firstL=value[0]*3;
        int secondL=value[1]*2;
        int thirdL=first+second+third;
        System.out.println(third);
        String res=Integer.toString(third);

        String firstLine=Integer.toString(firstL);
        String secondLine=Integer.toString(secondL);
        String thirdLine=Integer.toString(thirdL);

        answer1.setText(firstLine);
        answer2.setText(secondLine);
        answer3.setText(thirdLine);

        playCounter++;
            if(playCounter>=10){
                endGame();
            }
        }

    private void endGame() {

            AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(Math.this);
            alertDialogBuilder
                    .setMessage("Game Over \nP1: "+score)
                    .setCancelable(false)
                    .setPositiveButton("New", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent=new Intent(getApplicationContext(),Math.class);
                            startActivity(intent);
                            finish();
                        }
                    }).setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            AlertDialog alertDialog=alertDialogBuilder.create();
            alertDialog.show();


    }

}

