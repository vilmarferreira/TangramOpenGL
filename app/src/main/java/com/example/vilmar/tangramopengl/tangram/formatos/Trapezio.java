package com.example.vilmar.tangramopengl.tangram.formatos;

import com.example.vilmar.tangramopengl.tangram.Geometria;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by VILMAR on 30/09/2017.
 */

public class Trapezio extends Geometria {
        public Trapezio (float largura,float altura )
        {
            float[] coordenadas = {
                    -largura/2,0,
                    0,0,
                    -largura/4,altura/4,
                    largura/4,altura/4
            };

            CriaBuffer(coordenadas);
        }

}
