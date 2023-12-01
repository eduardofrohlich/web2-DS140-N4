import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastrarRoupaComponent } from './cadastrar-roupa.component';

describe('CadastrarRoupaComponent', () => {
  let component: CadastrarRoupaComponent;
  let fixture: ComponentFixture<CadastrarRoupaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CadastrarRoupaComponent]
    });
    fixture = TestBed.createComponent(CadastrarRoupaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
