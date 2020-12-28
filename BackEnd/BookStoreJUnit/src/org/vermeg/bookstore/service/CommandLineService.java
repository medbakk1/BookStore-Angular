package org.vermeg.bookstore.service;


import java.util.List;
import org.vermeg.bookstore.model.CommandLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("CommandLine")

public class CommandLineService {

	@Autowired
	org.vermeg.bookstore.dao.CommandLineDao CommandLineDao;
	
	@Transactional
	public List<CommandLine> getAllCommandLine() {
		return CommandLineDao.getAllCommandLine();
	}

	@Transactional
	public CommandLine getCommandLine(int id) {
		return CommandLineDao.getCommandLine(id);
	}

	@Transactional
	public void addCommandLine(CommandLine CommandLine) {
		CommandLineDao.addCommandLine(CommandLine);
	}

	@Transactional
	public void updateCommandLine(CommandLine CommandLine) {
		CommandLineDao.updateCommandLine(CommandLine);

	}

	@Transactional
	public void deleteCommandLine(int id) {
		CommandLineDao.deleteCommandLine(id);
	}
}

