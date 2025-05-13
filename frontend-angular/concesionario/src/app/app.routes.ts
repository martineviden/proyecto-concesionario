import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: '', redirectTo: 'vehiculos', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'registrarse', component: RegistrarseComponent },
  { path: 'vehiculos', component: VehiculosComponent },
  { path: 'tipo-vehiculo/:id', component: TipoVehiculoComponent },
  { path: 'reservar/:matricula', component: ReservaFormComponent },
  { path: 'mis-reservas', component: MisReservasComponent },
  { path: 'admin/reservas', component: AdminReservasComponent },
  { path: 'resena-form', component: ResenaFormComponent}
  

];

