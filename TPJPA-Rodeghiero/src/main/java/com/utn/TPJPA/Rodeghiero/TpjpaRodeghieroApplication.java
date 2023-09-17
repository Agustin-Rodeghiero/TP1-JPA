package com.utn.TPJPA.Rodeghiero;

import com.utn.TPJPA.Rodeghiero.entidades.*;
import com.utn.TPJPA.Rodeghiero.enums.Estado;
import com.utn.TPJPA.Rodeghiero.enums.FormaDePago;
import com.utn.TPJPA.Rodeghiero.enums.TipoDeEnvio;
import com.utn.TPJPA.Rodeghiero.enums.TipoProducto;
import com.utn.TPJPA.Rodeghiero.repositorios.ClienteRepository;
import com.utn.TPJPA.Rodeghiero.repositorios.RubroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class TpjpaRodeghieroApplication {

	@Autowired
	RubroRepository rubroRepository;

	@Autowired
	ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(TpjpaRodeghieroApplication.class, args);
		System.out.println("Estoy funcionando");

	}

	@Bean
	CommandLineRunner init(RubroRepository rubroRepository1, ClienteRepository clienteRepository1){
		return args -> {
			System.out.println("--------------TODAVIA-------FUNCIONO-----------");
			//Creamos algunas instancias de rubro
			Rubro rubro1 = Rubro.builder()
					.denominacion("Pizzas")
					.build();
			//Creamos las instancias de esos productos
			Producto producto1 = Producto.builder()
					.tiempoEstimadoCocina(20)
					.denominacion("Napolitana")
					.precioVenta(3000)
					.precioCompra(2000)
					.stockActual(20)
					.stockMinimo(5)
					.unidadMedida("unidad1")
					.receta("receta1")
					.tipoProducto(TipoProducto.Insumo)
					.build();
			Producto producto2 = Producto.builder()
					.tiempoEstimadoCocina(25)
					.denominacion("Tropical")
					.precioVenta(3300)
					.precioCompra(2100)
					.stockActual(10)
					.stockMinimo(5)
					.unidadMedida("unidad2")
					.receta("receta2")
					.tipoProducto(TipoProducto.Manufacturado)
					.build();
			Producto producto3 = Producto.builder()
					.tiempoEstimadoCocina(15)
					.denominacion("Especial")
					.precioVenta(2500)
					.precioCompra(1800)
					.stockActual(30)
					.stockMinimo(5)
					.unidadMedida("unidad3")
					.receta("receta3")
					.tipoProducto(TipoProducto.Insumo)
					.build();

			//Agregamos los productos al rubro
			rubro1.agregarProducto(producto1);
			rubro1.agregarProducto(producto2);
			rubro1.agregarProducto(producto3);

			//Guardamos Rubro
			rubroRepository.save(rubro1);

			//Creamos instancias de Cliente
			Cliente cliente1 = Cliente.builder()
					.nombre("Agustin")
					.apellido("Rodeghiero")
					.email("@email")
					.telefono("telefono1")
					.build();

			Cliente cliente2 = Cliente.builder()
					.nombre("Nicolas")
					.apellido("Lopez")
					.email("@email")
					.telefono("telefono2")
					.build();

			//Creamos instancias de Domicilio
			Domicilio domicilio1 = Domicilio.builder()
					.calle("España")
					.numero(5048)
					.localidad("Villa Nueva de Guaymallén")
					.build();

			Domicilio domicilio2 = Domicilio.builder()
					.calle("Chile")
					.numero(2112)
					.localidad("San José")
					.build();

			//Agregamos los domicilios a los clientes
			cliente1.agregarDomicilio(domicilio1);
			cliente2.agregarDomicilio(domicilio2);

			//Creamos instancias de DetallePedido
			DetallePedido detallePedido1 = DetallePedido.builder()
					.cantidad(5)
					.subtotal(8600)
					.build();
			DetallePedido detallePedido2 = DetallePedido.builder()
					.cantidad(8)
					.subtotal(3500)
					.build();
			DetallePedido detallePedido3 = DetallePedido.builder()
					.cantidad(4)
					.subtotal(5700)
					.build();

			//Configuramos fecha
			SimpleDateFormat formatoFecha = new SimpleDateFormat("yyy-MM-dd");
			String fechaString = "2023-09-11";

			//Parseamos la cadena en un objeto Date
			Date fecha = formatoFecha.parse(fechaString);

			//Creamos instancias de Pedido
			Pedido pedido1 = Pedido.builder()
					.fecha(fecha)
					.total(7428)
					.estado(Estado.Iniciado)
					.tipoDeEnvio(TipoDeEnvio.Delivery)
					.build();
			Pedido pedido2 = Pedido.builder()
					.fecha(fecha)
					.total(5250)
					.estado(Estado.Entregado)
					.tipoDeEnvio(TipoDeEnvio.Retira)
					.build();
			Pedido pedido3 = Pedido.builder()
					.fecha(fecha)
					.total(2500)
					.estado(Estado.Preparacion)
					.tipoDeEnvio(TipoDeEnvio.Delivery)
					.build();

			//Creamos instancias de Factura
			Factura factura1 = Factura.builder()
					.fecha(fecha)
					.total(3200)
					.numero(1)
					.dto(400)
					.formaDePago(FormaDePago.Efectivo)
					.build();
			Factura factura2 = Factura.builder()
					.fecha(fecha)
					.total(5400)
					.numero(2)
					.dto(600)
					.formaDePago(FormaDePago.ConTarjeta)
					.build();

			//Agregamos detalles a Pedido
			pedido1.agregarDetallePedido(detallePedido1);
			pedido1.agregarDetallePedido(detallePedido2);
			pedido2.agregarDetallePedido(detallePedido3);

			//Agregamos pedidos al cliente
			cliente1.agregarPedido(pedido1);
			cliente2.agregarPedido(pedido2);

			//Vinculamos los DetallePedido con Producto
			detallePedido1.setProducto(producto1);
			detallePedido2.setProducto(producto2);
			detallePedido3.setProducto(producto3);

			//Vinculamos Factura con Pedido
			pedido1.setFactura(factura1);
			pedido2.setFactura(factura2);

			//Guardamos Cliente
			clienteRepository.save(cliente1);
			clienteRepository.save(cliente2);

			//Recuperamos objeto rubro desde la base de datos
			Rubro rubroRecuperado = rubroRepository.findById(rubro1.getId()).orElse(null);
			if (rubroRecuperado != null){
				System.out.println("Denominacion: " + rubroRecuperado.getDenominacion());
				rubroRecuperado.mostrarProductos();
			}
			//Recuperamos Cliente desde la base de Datos
			Cliente clienteRecuperado = clienteRepository.findById(cliente1.getId()).orElse(null);
			if (clienteRecuperado != null){
				System.out.println("Nombre: " + clienteRecuperado.getNombre());
				System.out.println("Apellido: " + clienteRecuperado.getApellido());
				System.out.println("Email: " + clienteRecuperado.getEmail());
				System.out.println("Telefono: " + clienteRecuperado.getTelefono());
				System.out.println("----------------------------------------");
				clienteRecuperado.mostrarDomicilios();
				clienteRecuperado.mostrarPedidos();
			}
		};
	}
}
