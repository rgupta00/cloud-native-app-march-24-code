package com.orderapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@SpringBootApplication
public class OrderappApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OrderappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Flux<String> stringFlux=Flux.just("john","raj","keshav")
//				.concatWith(Flux.error(new RuntimeException("some bug")))
//				.concatWith(Flux.just("rajiv"))
//				.log();
//		stringFlux.subscribe(System.out::println,e-> System.out.println(e),()->System.out.println("done")  );

		//Mono
		//Mono<String> stringMono=Mono.just("raj").log();

		//using arr
//		String []arr=new String[]{"john","raj","keshav"};
//				Flux<String> stringFlux=Flux.fromArray(arr)
//				.log();
//		stringFlux.subscribe(System.out::println,e-> System.out.println(e),()->System.out.println("done")  );

		//collection
		//Flux.fromIterable()
//		List<String> data=List.of("john","raj","keshav");
//		Flux<String> stringFlux2=Flux.fromIterable(data)
//				.log();
//		stringFlux.subscribe(System.out::println,e-> System.out.println(e),()->System.out.println("done")  );


	}
}
