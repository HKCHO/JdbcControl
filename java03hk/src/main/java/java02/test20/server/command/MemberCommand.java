package java02.test20.server.command;

import java.io.PrintStream;
import java.util.Map;
import java.util.Scanner;

import java02.test20.server.Member;
import java02.test20.server.MemberDao;
import java02.test20.server.annotation.Command;
import java02.test20.server.annotation.Component;

@Component
public class MemberCommand {
	MemberDao memberDao;
	Scanner scanner;

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	@Command("add")
	public void add(Map<String, Object> params) {
		PrintStream out = (PrintStream)params.get("out");

		try {
			Member member = new Member();
			member.setUid((String)params.get("uid"));
			member.setPwd((String)params.get("pwd"));
			member.setEmail((String)params.get("email"));
			member.setName((String)params.get("name"));
			member.setTel((String)params.get("tel"));
			member.setFax((String)params.get("fax"));
			member.setAddr((String)params.get("addr"));
			member.setPhot((String)params.get("phot"));
			member.setAno(Integer.parseInt((String)params.get("ano")));
			memberDao.insert(member);
			out.println("저장하였습니다.");
			out.println();

		} catch (Exception e) {
			e.printStackTrace();
			out.println("서버가 바쁩니다. 잠시 후 다시 시도하세요.");
			out.println();
		}
	}

	@Command("delete")
	public void delete(Map<String, Object> params) {
		PrintStream out = (PrintStream) params.get("out");
		String uid = (String)params.get("uid");
		Member member = memberDao.selectOne(uid);
		if (member == null) {
			out.println("해당 번호의 제품 정보를 찾을 수 없습니다.");
			out.println();
			return;
		}

		memberDao.delete(uid);
		out.println("삭제하였습니다.");
		out.println();
	}

	@Command("list")
	public void list(Map<String, Object> params) {
		System.out.println("list 명령어를 입력받음.");
		int pageNo = 0;
		int pageSize = 0;

		if (params.get("pageNo") != null) {
			pageNo = Integer.parseInt((String)params.get("pageNo"));
			pageSize = 3;
		}

		if (params.get("pageSize") != null) {
			pageSize = Integer.parseInt((String)params.get("pageSize"));
		}

		PrintStream out = (PrintStream)params.get("out");
		for (Member member : memberDao.selectList(pageNo, pageSize)) {
			out.printf("%-3s %-20s %-10s %10s %10s %10s %7s %-3d\n", 
					member.getUid(),
					member.getPwd(),
					member.getEmail(),
					member.getName(),
					member.getTel(),
					member.getFax(),
					member.getAddr(),
					member.getAno());
		}
		out.println();
	}

	@Command("update")
	public void update(Map<String, Object> params) {
		PrintStream out = (PrintStream)params.get("out");

		try {
			Member member = new Member();
			
			member.setUid((String)params.get("uid"));
			member.setPwd((String)params.get("pwd"));
			member.setEmail((String)params.get("email"));
			member.setName((String)params.get("name"));
			member.setTel((String)params.get("tel"));
			member.setFax((String)params.get("fax"));
			member.setAddr((String)params.get("addr"));
			member.setPhot((String)params.get("phot"));
			member.setAno(Integer.parseInt((String)params.get("ano")));

			memberDao.update(member);
			out.println("변경하였습니다.");
			out.println();

		} catch (Exception e) {
			e.printStackTrace();
			out.println("서버가 바쁩니다. 잠시 후 다시 시도하세요.");
			out.println();
		}
	}

	@Command("view")
	public void view(Map<String, Object> params) throws Exception {
		String uid = (String)params.get("uid");

		Member member = memberDao.selectOne(uid);

		PrintStream out = (PrintStream)params.get("out");

		if (member == null) {
			out.println("해당 번호의 제품 정보를 찾을 수 없습니다.");
			out.println();
			return;
		}

		out.println("아이디: " + member.getUid());
		out.println("암호: " + member.getPwd());
		out.println("이메일: " + member.getEmail());
		out.println("주문자: " + member.getName());
		out.println("전화번호: " + member.getTel());
		out.println("팩스: " + member.getFax());
		out.println("상세주소: " + member.getAddr());
		out.println("주문자 사진: " + member.getPhot());
		out.println("주소번호: " + member.getAno());
		out.println();
	}
}









