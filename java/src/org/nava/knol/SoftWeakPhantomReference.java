package org.nava.knol;

import java.lang.ref.*;
import java.util.*;
import static java.lang.System.out;

/**
 * Read this before understanding the code
 * http://www.kdgregory.com/index.php?page=java.refobj
 * 
 * @author nambi
 * 
 */
public class SoftWeakPhantomReference
{

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args)
	{
		ReferenceQueue<?> referenceQueue = new ReferenceQueue<Object>();

		Object object = new Object() {
			public String toString()
			{
				return "Referenced Object";
			}
		};

		Object data = new Object() {
			public String toString()
			{
				return "Data";
			}
		};

		HashMap<Reference<Object>, Object> map = new HashMap<Reference<Object>, Object>();

		Reference<Object> reference = null;

		// Create the reference to the object
		String testWhat = "-weak";
		if (testWhat.equalsIgnoreCase("-soft"))
		{
			out.println("Testing SoftReference.");
			out.println("-------------------------");
			out.println();
			reference = new SoftReference(object, referenceQueue);
		} else if (testWhat.equalsIgnoreCase("-weak"))
		{
			out.println("Testing WeakReference.");
			out.println("-------------------------");
			out.println();
			reference = new WeakReference(object, referenceQueue);
		} else
		{
			out.println("Testing PhantomReference.");
			out.println("-------------------------");
			out.println();
			reference = new PhantomReference(object, referenceQueue);
		}

		// Associate data (value) with reference (key) in map
		map.put(reference, data);

		// Check that a reference to an object was created
		out.println("Contents of reference: " + reference.get());
		out.println("Contents of Map: " + map.get(reference));

		// Check whether the Reference Object is enqueued
		out.println("reference.isEnqueued(): " + reference.isEnqueued());

		// Run the garbage collector, and
		// Check the reference objects referent
		out.println("-----------------Running garbage collector now.------------------");
		System.gc();
		out.println("Contents of reference: " + reference.get());
		out.println("Contents of Map: " + map.get(reference));
		// Check whether the reference object is enqueued
		out.println("reference.isEnqueued(): " + reference.isEnqueued());

		out.println();
		out.println("****Clearing all the strong references, thus freeing up objects for garbage collection.");
		object = null;
		data = null;

		out.println("-----------------Running garbage collector now.------------------");
		System.gc();
		out.println("Contents of reference: " + reference.get());
		out.println("Contents of Map: " + map.get(reference));
		// Check whether the reference object is enqueued
		out.println("reference.isEnqueued(): " + reference.isEnqueued());
	}
}
