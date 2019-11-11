package br.com.tt.locadoraveiculosweb.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.tt.locadoraveiculosweb.exception.RegraNegocioException;
import br.com.tt.locadoraveiculosweb.model.Caminhao;
import br.com.tt.locadoraveiculosweb.model.Carro;
import br.com.tt.locadoraveiculosweb.model.Moto;
import br.com.tt.locadoraveiculosweb.model.Veiculo;
import br.com.tt.locadoraveiculosweb.model.dto.VeiculoDTO;
import br.com.tt.locadoraveiculosweb.model.enums.TipoVeiculo;
import br.com.tt.locadoraveiculosweb.service.VeiculoService;

@Controller
public class VeiculoController {

	private final VeiculoService veiculoService;

	public VeiculoController(VeiculoService veiculoService) {
		this.veiculoService = veiculoService;
	}

	@GetMapping("/rota-veiculo-voltar-index")
	public String voltarTelaInicial() {
		return "index";
	}

	@GetMapping("/rota-cadastrar-veiculo")
	public String abrirTelaCadastroVeiculo(Model model) {
		model.addAttribute("tiposVeiculos", 
				veiculoService.listarTiposVeiculo());
		model.addAttribute("tiposCombustivel", 
				veiculoService.listarTiposCombustivel());
		model.addAttribute("tiposCaminhao", 
				veiculoService.listarTiposCaminhao());
		model.addAttribute("tiposCambio", 
				veiculoService.listarTiposCambio());
		model.addAttribute("numerosCilindrada", 
				veiculoService.listarTiposCilindrada());
		model.addAttribute("tiposCarro", 
				veiculoService.listarTiposCarro());
		model.addAttribute("numerosPortas", 
				veiculoService.listarNumerosPorta());
		
		return "veiculo-form";
	}

	// nome da rota chamada
	@GetMapping("/rota-veiculo-listar")
	public String redirecionarParaListaVeiculos(Model model) {
		List<Veiculo> veiculos = veiculoService.listarTodos();
		VeiculoDTO veiculoDTO;
		List<VeiculoDTO> dtos = new LinkedList<>();
		
		for (Veiculo veiculo : veiculos) {
			veiculoDTO = new VeiculoDTO();
			veiculoDTO.setPlaca(veiculo.getPlaca());
			veiculoDTO.setMarca(veiculo.getMarca());
			veiculoDTO.setModelo(veiculo.getModelo());
			veiculoDTO.setQuilometragem(veiculo.getQuilometragem());
			veiculoDTO.setTipoCombustivel(veiculo.getTipoCombustivel());
			
			if (veiculo instanceof Caminhao) {
				veiculoDTO.setTipoVeiculo(TipoVeiculo.CAMINHAO);
				veiculoDTO.setCambio(((Caminhao) veiculo).getCambio());
				veiculoDTO.setTipoCaminhao(((Caminhao) veiculo).getTipo());
			} else if (veiculo instanceof Carro) {
				veiculoDTO.setTipoVeiculo(TipoVeiculo.CARRO);
				veiculoDTO.setTipoCarro(((Carro) veiculo).getTipo());
				veiculoDTO.setCambio(((Carro) veiculo).getCambio());
				veiculoDTO.setTipoCombustivel(veiculo.getTipoCombustivel());
			} else {
				veiculoDTO.setTipoVeiculo(TipoVeiculo.MOTO);
				veiculoDTO.setCilindrada(((Moto)veiculo).getCilindrada());
			}
			
			dtos.add(veiculoDTO);
		}
		
		model.addAttribute("veiculos", dtos);
		// nome do template que será renderizado
		return "/veiculo-listar";
	}

	@PostMapping("/rota-veiculo-form")
	public String adicionarVeiculo(VeiculoDTO veiculoDTO, 
			RedirectAttributes atts) {
        Veiculo veiculo;
		
		if (TipoVeiculo.CAMINHAO == veiculoDTO.getTipoVeiculo()) {
			veiculo = new Caminhao(
					veiculoDTO.getPlaca(),
					veiculoDTO.getMarca(),
					veiculoDTO.getModelo(),
					veiculoDTO.getQuilometragem(),
					veiculoDTO.getTipoCombustivel(),
					veiculoDTO.getTipoCaminhao(),
					veiculoDTO.getCambio());
		} else if (TipoVeiculo.CARRO == veiculoDTO.getTipoVeiculo()) {
			veiculo = new Carro(
					veiculoDTO.getPlaca(),
					veiculoDTO.getMarca(),
					veiculoDTO.getModelo(),
					veiculoDTO.getQuilometragem(),
					veiculoDTO.getTipoCombustivel(),
					veiculoDTO.getTipoCarro(),
					veiculoDTO.getCambio(),
					veiculoDTO.getNumeroPortas());
		} else  {
			veiculo = new Moto(
					veiculoDTO.getPlaca(),
					veiculoDTO.getMarca(),
					veiculoDTO.getModelo(),
					veiculoDTO.getQuilometragem(),
					veiculoDTO.getTipoCombustivel(),
					veiculoDTO.getCilindrada());
		}
		
		
		try {
			veiculoService.incluir(veiculo);
		} catch (RegraNegocioException excecao) {
			atts.addFlashAttribute("erro", excecao.getMessage());
			return "redirect:/rota-cadastrar-veiculo";
		}
		
		return "redirect:/rota-veiculo-listar";
	}
}
