package Assignment;

public abstract class Conslist<T> 
{    
	//Type Parameterization...
	// T represents the datatype of each element
	abstract public T head();
	abstract public Conslist<T> tail();
	abstract public T reduce(ReduceClosure<T> f);
	
	public boolean isEmpty() 
	{ 
		return true; 
	}
	public void print() {}

	public Conslist<?> map(MapClosure<T,?> f) 
	{ 
		return Cons.Nil; 
	}
}


