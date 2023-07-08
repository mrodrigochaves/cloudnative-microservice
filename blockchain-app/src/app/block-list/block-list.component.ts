import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-block-list',
  templateUrl: './block-list.component.html',
  styleUrls: ['./block-list.component.scss'],
})
export class BlockListComponent {
  constructor(private http: HttpClient) {}

  onCreateBlock() {
    const block = {
      data: 'Test',

    };

    this.http.post('http://localhost:8080/blocks', block).subscribe(
      (response) => {
        console.log('Create Block with sucess:', response);
      },
      (error) => {
        console.error('Error creating block:', error);
      }
    );
  }
}
