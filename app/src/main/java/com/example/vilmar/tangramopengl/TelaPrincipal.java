package com.example.vilmar.tangramopengl;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.vilmar.tangramopengl.tangram.formatos.Quadrado;
import com.example.vilmar.tangramopengl.tangram.formatos.Trapezio;
import com.example.vilmar.tangramopengl.tangram.formatos.Triangulo;


import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;



class Renderizador implements GLSurfaceView.Renderer
{

    int iFPS;
    long tempoInicial=0;
    long tempoAtual=0;
    float PosX=000,PosY=000;
    float PosLargura,PosAltura;
    int dir=1,dir2=1;
    float angulo=1;
    int lado=200,H=600;
    Triangulo triangulo0,triangulo1,triangulo2,triangulo3,triangulo4;
    Quadrado quadrado=null;
    Trapezio trapezio= null;
    @Override
    //será chamado quando o aplicativo for criado, 1 vez só
    public void onSurfaceCreated(GL10 vrOpengl, EGLConfig eglConfig) {

    }

    @Override
    //Vai ser chamada quando a superficie mudar
    public void onSurfaceChanged(GL10 vrOpenGL, int largura, int altura) {


        //configura a cor que sera utilizada para limpar o fundo da tela
        vrOpenGL.glClearColor(1.0f,1.0f,1.0f,1.0f);
        //Configura a area de visualização utilizada na tela do aparelho
        vrOpenGL.glViewport(0,0,largura,altura);


        triangulo0= new Triangulo(largura, largura);
        triangulo1= new Triangulo(largura, largura);
        triangulo2=new Triangulo(largura, largura);
        triangulo3= new Triangulo(largura, largura);
        triangulo4= new Triangulo(largura, largura);
        quadrado= new Quadrado(largura,largura);
        trapezio= new Trapezio(largura,largura);

       // triangulo.setPosXY(largura,altura);
        float escala50[]= {0.5f,0.5f,0.5f};
        float escala25[]= {0.25f,0.25f,0.25f};

        triangulo0.setMover(largura/4,altura/4);
        float cor[]={1.0f,0.0f,1.0f};
        triangulo0.setCor(cor);
        triangulo0.setEscala(escala50);

        triangulo0.setAngulo(-135);


        triangulo1.setMover(largura/2+largura/22,altura/2-altura/6);
        float cor2[]={1.0f,0.0f,0.0f};
        triangulo1.setCor(cor2);
        triangulo1.setAngulo(90);
        triangulo1.setEscala(escala50);

        triangulo2.setMover(largura/5,altura/3);
        float cor3[]={0.0f,1.0f,0.0f};
        triangulo2.setCor(cor3);
        float escala2[]= {0.15f,0.15f,0.15f};
        triangulo2.setAngulo(90);
        triangulo2.setEscala(escala2);

        triangulo3.setMover(largura/2-largura/12,altura/4);
       // float escala3[]= {0.75f,0.75f,0.75f};
        float cor4[]={0.0f,0.0f,1.0f}; //triangulo azul
        triangulo3.setCor(cor4);
        triangulo3.setEscala(escala25);
        triangulo3.setAngulo(270);

        triangulo4.setMover(largura/4+25,altura/2-altura/10);
        float cor5[]={1.0f,1.0f,0.0f};
        triangulo4.setCor(cor5);
        triangulo4.setEscala(escala2);
        triangulo4.setAngulo(45);

        quadrado.setMover(largura-largura/3,altura/2-altura/8);
        float corQuadrado[]= {0,0,0};
        quadrado.setAngulo(10);
        quadrado.setCor(corQuadrado);
        quadrado.setEscala(escala25);

        trapezio.setAngulo(180);
        trapezio.setMover(largura/2+largura/7,altura/4+30);
        float corTrapezio[]= {(float)Math.random(),(float) Math.random(),(float) Math.random()};
        trapezio.setCor(corTrapezio);
        trapezio.setEscala(escala25);
        trapezio.setInvert();

        vrOpenGL.glMatrixMode(GL10.GL_PROJECTION);
        vrOpenGL.glLoadIdentity();  // carrega a matriz identidade para tirar o lixo da memoria
        vrOpenGL.glOrthof(0,largura, 0,altura,1,-1);
        vrOpenGL.glMatrixMode(GL10.GL_MODELVIEW);
        vrOpenGL.glLoadIdentity();
        vrOpenGL.glEnableClientState(GL10.GL_VERTEX_ARRAY);

    }

    @Override

    public void onDrawFrame(GL10 vrOpengl) {
        vrOpengl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        triangulo0.desenha(vrOpengl);

          triangulo1.desenha(vrOpengl);

          triangulo3.desenha(vrOpengl);

          quadrado.desenha(vrOpengl);
        trapezio.desenha(vrOpengl);

                triangulo4.desenha(vrOpengl);
                triangulo2.desenha(vrOpengl);

    }

}

public class TelaPrincipal extends AppCompatActivity {
    //Cria uma variavel de referencia para a OpenGL
    GLSurfaceView superficieDesenho=null;
    Renderizador render=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Valida a variavel de referencia com uma instancia da superficie
        superficieDesenho=new GLSurfaceView(this);
        render= new Renderizador();
        //Ligando classe
        superficieDesenho.setRenderer(render);
        //Configura a tela do aparelho para mostrar a sup. de desenho
        setContentView(superficieDesenho);
        //IMPRIME UMA MENSAGEM NO LOG COM A TAG FPS E O TEXTO DO 2 PARAMETRO
        Log.i("FPS","Alguma coisa");

    }
}