# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import models

# Create your models here.

class Author(models.Model):
    author_name = models.CharField(max_length=100)

    def __str__(self):
        return self.author_name

class Quote(models.Model):
    quote_text = models.CharField(max_length=100)
    quote_author = models.ForeignKey(Author)

    def __str__(self):
        return self.quote_text
