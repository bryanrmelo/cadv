import { Playlist } from './playlist';
import { Usuario } from './usuario';
export class Video {

  id: number;
  titulo: string;
  link: string;
  autor: Usuario;
  privado: boolean;
  playlist: Playlist;
  categoria: string;
}
