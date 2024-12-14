package com.han.Controller;

import java.util.Map;

import org.apache.catalina.mbeans.MBeanUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.han.Model.employee;
import com.han.Service.IemployeeService;

@Controller
public class controller {

	@Autowired
	public IemployeeService service;
	
	@GetMapping("/")
	public String home() {
		//return lvn
		return "home";
	}

	@GetMapping("/report")
	public String Report(Map<String,Object> map) {
		Iterable<employee> it=service.FetchAllEmployee();
		map.put("empList", it);
		return "showreport";
	}
	@GetMapping("/add")
    public String add(@ModelAttribute("emp")employee emp) {
		return "register";
	}
	@PostMapping("/add")
	public String register(RedirectAttributes re,@ModelAttribute("emp")employee emp) {
		String msg=service.addEmployee(emp);
		re.addFlashAttribute("resultMsg", msg);
		return"redirect:report";
	}
	@GetMapping("/edit")
	public String edit(@ModelAttribute("emp")employee emp,@RequestParam("empno")int empno) {
		employee emp1=service.editEmployeebyId(empno);
		BeanUtils.copyProperties(emp1, emp);
		return "update";
	}
	@PostMapping("/edit")
	public String update(@ModelAttribute("emp")employee emp,RedirectAttributes ra) {
		
		String msg=service.updateEmpBy(emp);
		ra.addFlashAttribute("resultMsg",msg);
		return"redirect:report";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("empno")int empno,RedirectAttributes ra) {
		String msg=service.DeleteEmployee(empno);
		ra.addFlashAttribute("resultMsg",msg);
		return "redirect:report";
	}
	
}
