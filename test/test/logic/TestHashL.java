package test.logic;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.LinearProbingHashST;
import model.data_structures.Ayuda.listaDoble;


public class TestHashL {
	private LinearProbingHashST<Integer, listaDoble<Integer>> tabla1;

	@Before
	public void SetUp1(){
		tabla1 =new LinearProbingHashST<Integer, listaDoble<Integer>>(10);

	}
	@Test
	public void testConstructor(){
		SetUp1();
		assertTrue(tabla1 != null);
	}
	@Test
	public void testPut(){
		SetUp1();
		listaDoble<Integer>S= new listaDoble<Integer>();
		S.agregarInicio(2);
		tabla1.put(0, S);
		assertTrue(tabla1.get(0).darInicio().getItem()==2);
		assertTrue(tabla1.size()==1);
	}
	@Test
	public void testGet(){
		SetUp1();
		listaDoble<Integer>S= new listaDoble<Integer>();
		S.agregarInicio(2);
		tabla1.put(0, S);
		assertTrue(tabla1.get(0).darInicio().getItem()==2);
	}
	@Test
	public void testDelete(){
		SetUp1();
		listaDoble<Integer>S= new listaDoble<Integer>();
		S.agregarInicio(2);
		tabla1.put(0, S);
		tabla1.delete(2);
		assertTrue(tabla1.size()==1);
		tabla1.delete(0);
		assertTrue(tabla1.size()==0);
	}

}
