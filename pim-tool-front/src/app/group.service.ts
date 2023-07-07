import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Group } from './model/group';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class GroupService {

  private apiUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  getAllGroups(): Observable<Group[]> {
    return this.http.get<Group[]>(`${this.apiUrl}/groups/`);
  }
}
