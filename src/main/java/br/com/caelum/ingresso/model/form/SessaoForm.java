package br.com.caelum.ingresso.model.form;

import java.time.LocalTime;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.dao.SalaDao;
import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

@Controller
public class SessaoForm {
	@Autowired
	private FilmeDao filmeDao;

	@Autowired
	private SalaDao salaDao;

	private Integer id;

	@NotNull
	private Integer salaId;

	@DateTimeFormat(pattern = "HH:mm")
	@NotNull
	private LocalTime horario;

	@NotNull
	private Integer filmeId;

	public FilmeDao getFilmeDao() {
		return filmeDao;
	}

	public void setFilmeDao(FilmeDao filmeDao) {
		this.filmeDao = filmeDao;
	}

	public SalaDao getSalaDao() {
		return salaDao;
	}

	public void setSalaDao(SalaDao salaDao) {
		this.salaDao = salaDao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSalaId() {
		return salaId;
	}

	public void setSalaId(Integer salaId) {
		this.salaId = salaId;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public Integer getFilmeId() {
		return filmeId;
	}

	public void setFilmeId(Integer filmeId) {
		this.filmeId = filmeId;
	}

	public Sessao toSessao(SalaDao salaDao, FilmeDao filmeDao) {
		Filme filme = filmeDao.findOne(filmeId);
		Sala sala = salaDao.findOne(salaId);

		Sessao sessao = new Sessao(horario, filme, sala);
		sessao.setId(id);

		return sessao;
	}

}
