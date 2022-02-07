SELECT * FROM ARTISTAS 
SELECT * FROM REPERTORIO 

select * 
  from repertorio r, artistas a, musicas m 
  where r.artista_id= a.artista_id 
      and m.musica_id = r.musica_id;

select a.primeiro_nome,a.ultimo_nome, m.nome, m.banda, r.status
  from repertorio r, artistas a, musicas m 
  where r.artista_id= a.artista_id 
      and m.musica_id = r.musica_id;
      
#### Criar Indexes  #####
create unique index idx_repertorio_artista on repertorio (artista_id, musica_id);
create unique index idx_repertorio_usuario on pedido (repertorio_id, usuario_id);

####  Queries Pedidos de Música ####
select * from pedido p, repertorio r, artistas a, musicas m, usuario u where p.repertorio_id = r.repertorio_id and p.usuario_id = u.usuario_id and r.artista_id =  a.artista_id and r.musica_id = m.musica_id and  r.artista_id = 1;
select p.pedido_id, m.nome, m.banda, p.data_entrada, u.primeiro_nome 
 from pedido p, repertorio r, usuario u, artistas a, musicas m
  where p.repertorio_id = r.repertorio_id 
     and p.usuario_id = u.usuario_id 
      and r.artista_id =  a.artista_id 
       and r.musica_id = m.musica_id 
        and  r.artista_id = 1 
      order by p.data_entrada desc;