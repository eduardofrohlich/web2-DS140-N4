import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RelatorioClienteFielComponent } from './relatorio-cliente-fiel.component';

describe('RelatorioClienteFielComponent', () => {
  let component: RelatorioClienteFielComponent;
  let fixture: ComponentFixture<RelatorioClienteFielComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RelatorioClienteFielComponent]
    });
    fixture = TestBed.createComponent(RelatorioClienteFielComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
