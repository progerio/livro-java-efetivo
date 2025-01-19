package org.progerio;

import static java.lang.System.out;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryUsage;
import java.util.List;
import java.util.Locale;

public class App {

	public static int MEGA = 1024 * 1024;

	public static String FORMAT = "  (%.2fmb)";

	public static void main(String[] args) {
		MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
		out.println("::: Memória heap :::");
		out.println();

		MemoryUsage heapMemory = memoryBean.getHeapMemoryUsage();
		out.println("Tamanho Inicial :: " + heapMemory.getInit()
				+ String.format(Locale.US, FORMAT, (double) heapMemory.getInit() / MEGA));
		out.println("Tamanho Atual :: " + heapMemory.getCommitted()
				+ String.format(Locale.US, FORMAT, (double) heapMemory.getCommitted() / MEGA));
		out.println("Usado :: " + heapMemory.getUsed()
				+ String.format(Locale.US, FORMAT, (double) heapMemory.getUsed() / MEGA));
		out.println("Máximo :: " + heapMemory.getMax()
				+ String.format(Locale.US, FORMAT, (double) heapMemory.getMax() / MEGA));
		out.println();
		out.println("::: Memória non-heap :::");
		out.println();

		MemoryUsage nonheapMemory = memoryBean.getNonHeapMemoryUsage();
		out.println("Tamanho Inicial :: " + nonheapMemory.getInit()
				+ String.format(Locale.US, FORMAT, (double) nonheapMemory.getInit() / MEGA));
		out.println("Tamanho Atual :: " + nonheapMemory.getCommitted()
				+ String.format(Locale.US, FORMAT, (double) nonheapMemory.getCommitted() / MEGA));
		out.println("Usado :: " + nonheapMemory.getUsed()
				+ String.format(Locale.US, FORMAT, (double) nonheapMemory.getUsed() / MEGA));
		out.println("Máximo :: " + nonheapMemory.getMax()
				+ String.format(Locale.US, FORMAT, (double) nonheapMemory.getMax() / MEGA));
		out.println();

		out.println(":: Pool de memórias (organização JVM) ::");
		out.println();
		List<MemoryPoolMXBean> list = ManagementFactory.getMemoryPoolMXBeans();
		for (MemoryPoolMXBean m : list) {
			out.println("Nome do Pool :: " + m.getName());
			out.println("Grupo :: " + m.getType());
			out.println();
			MemoryUsage usage = m.getUsage();
			out.println(
					"Inicial: " + usage.getInit() + String.format(Locale.US, FORMAT, (double) usage.getInit() / MEGA));
			out.println("Atual: " + usage.getCommitted()
					+ String.format(Locale.US, FORMAT, (double) usage.getCommitted() / MEGA));
			out.println(
					"Usado: " + usage.getUsed() + String.format(Locale.US, FORMAT, (double) usage.getUsed() / MEGA));
			out.println("Maximo: " + usage.getMax() + String.format(Locale.US, FORMAT, (double) usage.getMax() / MEGA));
			out.println();
		}
	}
}
