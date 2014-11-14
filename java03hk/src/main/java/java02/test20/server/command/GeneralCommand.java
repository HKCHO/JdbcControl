package java02.test20.server.command;

import java.io.PrintStream;
import java.util.Map;
import java02.test20.server.MemberDao;
import java02.test20.server.annotation.Command;
import java02.test20.server.annotation.Component;

@Component
public class GeneralCommand {
  MemberDao memberDao;
  
  public void setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Command("help")
  public void help(Map<String, Object> params) throws Exception {
    PrintStream out = (PrintStream)params.get("out");
    out.println("list");
    out.println("view?uid=<아이디>");
    out.println("add?uid=<아이디>&pwd=<암호>&email=<이메일>&name=<고객명>&tel=<고객전화번호>"
    		+ "&fax=<고객팩스번호>&addr=<고객주소>&phot=<고객사진url>&ano=<주소번호>");
    out.println("delete?uid=<아이디>");
    out.println("update?uid=<아이디>");
    out.println();
  }
  
  
}









