package br.com.escolar.config;
import br.com.escolar.dtos.UsuarioDto;
import br.com.escolar.services.UsuarioService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class ServicoDetalhesUsuarioPersonalizado implements UserDetailsService {

    // Injete seu serviço ou repositório de usuários aqui
    private UsuarioService usuarioService;

    public ServicoDetalhesUsuarioPersonalizado(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    public UserDetails loadUserByUsername(String nomeUsuario) throws UsernameNotFoundException {
        // Implemente a lógica para carregar os detalhes do usuário a partir da fonte de dados

        UsuarioDto usuarioDto = usuarioService.findByNomeUsuario(nomeUsuario);
        if (usuarioDto == null) {
            throw new UsernameNotFoundException("Nome de usuário não encontrado: " + nomeUsuario);
        }

        // Crie e retorne um UserDetails com base nas informações do usuário
        return User.withUsername(usuarioDto.getNome())
                .password(usuarioDto.getSenha())
                .roles("USER")  // Defina os papéis apropriados aqui
                .build();
    }
}
