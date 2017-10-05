package com.example.vilmar.tangramopengl.tangram.formatos;

import com.example.vilmar.tangramopengl.tangram.Geometria;

/**
 * Created by VILMAR on 25/09/2017.
 */

public class Triangulo extends Geometria
{
    public Triangulo(float largura, float altura) {
        float[] coordenadas = {
               -largura/4,-altura/4,
                -largura/4,altura/4,
                0,0
        };

        CriaBuffer(coordenadas);

    }
}
