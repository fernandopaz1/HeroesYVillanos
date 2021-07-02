package main;

import java.util.function.BiFunction;

/**
 * Operación es un wrapper de {@code BiFuction<Float, Float, Float>}
 * 
 * A partir de los valores de dos atributos calcula el valor de un tercero
 *  
 */
public interface Operacion extends BiFunction<Float, Float, Float> {

}
