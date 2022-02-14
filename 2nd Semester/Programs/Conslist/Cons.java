package Assignment;

import java.util.*;

public class Cons<T> extends Conslist<T> 
{
	
	T h;
	Conslist<T> t;
	
	public static final Conslist<Object> Nil = new Conslist<Object>() {

		@Override
		public Object head() 
		{
			throw new NullPointerException("Nil has no head");
		}

		@Override
		public Conslist<Object> tail() 
		{
			return this;
		}
		
		public Object reduce(ReduceClosure<Object> f) 
		{
			throw new NullPointerException("Nil has no head");
		}		
	};
	
	public Cons(T h, Conslist<T> t) 
	{
		this.h = h;
		this.t = t;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> Conslist<T> list(T...lists) 
	{
		//return new Cons(lists[0], make(1, lists));
		return make_tr((Conslist<T>)Nil, lists.length-1, lists);
	}
	
	@SuppressWarnings({ "unused", "unchecked" })
	private static <T> Conslist<T> make(int index,T...lists) 
	{
		if (index >= lists.length)
			return (Conslist<T>) Nil;
		else return new Cons<T>(lists[index], make(++index, lists));
	}
	
	private static <T> Conslist<T> make_tr(Conslist<T> acc, int index, @SuppressWarnings("unchecked") T...lists) 
	{
		if (index < 0)
			return acc;
		
		else return make_tr(new Cons<T>(lists[index], acc), --index, lists);
	}

	@Override
	public T head() { return h; }

	@Override
	public Conslist<T> tail() { return t; }
	
	@Override
	public boolean isEmpty() { return false; }
		
	@Override
	public void print() 
	{
		System.out.print(h + " ");
		//tail recursion
		t.print();	
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes"})
	@Override
	public Conslist<?> map(MapClosure<T,?> funct) 
	{
		return new Cons(funct.lambda(h), t.map(funct));
		
	}
	
	@Override
	public T reduce(ReduceClosure<T> funct) 
	{
		return reduce_tr(this.head(), this.tail(), funct);
	}
	
	private static <T> T reduce_tr(T acc, Conslist<T> c, ReduceClosure<T> f) {
		if(c == Nil) return acc;
		else {
			return reduce_tr(f.lambda(acc,  c.head()), c.tail(), f);
			
		}
	}
		
	public static void main(String[] args)
	{
		Conslist<Double> c = Cons.list(5.4, 8.2, 5.7, 9.0, 2.2, 1.9, 16.76);
		c.print();
		//if(c == Nil) System.out.println("Empty list");
		System.out.println();
		
		MapClosure<Double, Double> m = new MapClosure<Double, Double>() 
		{
			public Double lambda(Double e) { return e*e; }
		};
		
		
		ReduceClosure<Double> r = new ReduceClosure<Double>() 
		{
			public Double lambda(Double acc, Double e) { return acc+e; }
		};
		
		Conslist cSq = c.map(m);
		System.out.println("Mapped numbers: ");
		cSq.print();
		System.out.println();
		System.out.println("Reduce function: ");
		System.out.println(cSq.reduce(r));
		System.out.println();
	}
}
