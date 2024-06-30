package my.gameheaven;

import java.io.ObjectOutputStream;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ConnectedUser {
	private String userId;
	@NonNull
	private ObjectOutputStream oos;
	
}
