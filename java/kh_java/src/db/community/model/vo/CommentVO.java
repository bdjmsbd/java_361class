package db.community.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentVO {

	private int cm_num;
	private String cm_content;
	private int cm_po_num;
	private int cm_ori_num;
	private String cm_date;
	private String cm_me_id;
	private int cm_report;
	private int cm_state;

	public CommentVO(String content, int po_num, String id) {
		cm_po_num = po_num;
		cm_content = content;
		cm_me_id = id;
	}

	@Override
	public String toString() {
		return cm_me_id + " | " + cm_content + " | " + cm_date;
	}
	
	

}
